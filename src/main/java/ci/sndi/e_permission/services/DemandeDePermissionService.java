package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.DemandeDePermission;
import ci.sndi.e_permission.repositories.DemandeDePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeDePermissionService {

    private final DemandeDePermissionRepository demandeDePermissionRepository;


    public DemandeDePermissionService(DemandeDePermissionRepository demandeDePermissionRepository) {
        this.demandeDePermissionRepository = demandeDePermissionRepository;
    }

    public List<DemandeDePermission> getAllDemandeDePermissions() {
        return demandeDePermissionRepository.findAll();
    }

    public DemandeDePermission createDemandeDePermission(DemandeDePermission demandeDePermission) {
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
