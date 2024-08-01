package ci.sndi.e_permission.services;

import ci.sndi.e_permission.dto.DemandeDePermissionDto;
import ci.sndi.e_permission.models.DemandeDePermission;
import ci.sndi.e_permission.models.TypeDePermission;
import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.repositories.DemandeDePermissionRepository;
import ci.sndi.e_permission.repositories.StatutDemandeRepository;
import ci.sndi.e_permission.repositories.TypeDePermissionRepository;
import ci.sndi.e_permission.repositories.UtilisateurRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeDePermissionService {

    
    private final DemandeDePermissionRepository demandeDePermissionRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final TypeDePermissionRepository typeDePermissionRepository;
    private final StatutDemandeRepository statutDemandeRepository;


    public DemandeDePermissionService(DemandeDePermissionRepository demandeDePermissionRepository, UtilisateurRepository utilisateurRepository, 
    TypeDePermissionRepository typeDePermissionRepository,  StatutDemandeRepository statutDemandeRepository) {
        this.demandeDePermissionRepository = demandeDePermissionRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.typeDePermissionRepository = typeDePermissionRepository;
        this.statutDemandeRepository = statutDemandeRepository;
        
    }

    public List<DemandeDePermission> getAllDemandeDePermissions() {
        return demandeDePermissionRepository.findAll();
    }

    public DemandeDePermission createDemandeDePermission(DemandeDePermissionDto demandeDePermissionDto) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(demandeDePermissionDto.getUserEmail()).orElseThrow(
            () -> new IllegalArgumentException("Utilisateur non trouvé avec l'email : " + demandeDePermissionDto.getUserEmail())
        );
        TypeDePermission typeDePermission = typeDePermissionRepository.findByNom(demandeDePermissionDto.getTypeDePermission()).orElseThrow(
            ()->new IllegalStateException("No type de permission found")
        );

        DemandeDePermission demandeDePermission = new DemandeDePermission();
        demandeDePermission.setDateDebut(demandeDePermissionDto.getDateDebut());
        demandeDePermission.setDateFin(demandeDePermissionDto.getDateFin());
        demandeDePermission.setDescription(demandeDePermissionDto.getDescription());
        demandeDePermission.setTypeDePermission(typeDePermission);
        demandeDePermission.setUtilisateur(utilisateur);
        demandeDePermission.setStatutDemande(statutDemandeRepository.findByCode("AT").orElseThrow(
            () -> new IllegalStateException ("Not found")
        ));

        return demandeDePermissionRepository.save(demandeDePermission);
    }

    public Optional<DemandeDePermission> getDemandeDePermissionById(Long id) {
        return demandeDePermissionRepository.findById(id);
    }

    public DemandeDePermission updateDemandeDePermission(Long id, DemandeDePermission demandeDePermissionDetails) {
        DemandeDePermission demandeDePermission = demandeDePermissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DemandeDePermission non trouvée avec l'ID : " + id));

        demandeDePermission.setDateDebut(demandeDePermissionDetails.getDateDebut());
        demandeDePermission.setDateFin(demandeDePermissionDetails.getDateFin());
        demandeDePermission.setCommentaire(demandeDePermissionDetails.getCommentaire());
        demandeDePermission.setUtilisateur(demandeDePermissionDetails.getUtilisateur());
        demandeDePermission.setStatutDemande(demandeDePermissionDetails.getStatutDemande());
        demandeDePermission.setTypeDePermission(demandeDePermissionDetails.getTypeDePermission());
        // Mettez à jour d'autres champs selon vos besoins

        return demandeDePermissionRepository.save(demandeDePermission);
    }

    public void deleteDemandeDePermission(Long id) {
        demandeDePermissionRepository.deleteById(id);
    }
}
