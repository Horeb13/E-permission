package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Assignation;
import ci.sndi.e_permission.models.AssignationId;
import ci.sndi.e_permission.repositories.AssignationRepository;
import ci.sndi.e_permission.repositories.RoleRepository;
import ci.sndi.e_permission.repositories.UtilisateurRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignationService {

    private final AssignationRepository assignationRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;

    public AssignationService(AssignationRepository assignationRepository, UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.assignationRepository = assignationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    public List<Assignation> getAllAssignations() {
        return assignationRepository.findAll();
    }

    public Assignation getAssignationById(AssignationId id) {
        return assignationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignation not found"));
    }

    public void createAssignation(Long userId, Long roleId) {
        if (userId == null || roleId == null) {
            throw new IllegalArgumentException("User ID and Role ID must not be null");
        }
    
        AssignationId assignationId = new AssignationId();
        assignationId.setUtilisateur(userId);
        assignationId.setRole(roleId);
    
        Assignation assignation = new Assignation();
        assignation.setId(assignationId);
    
        assignationRepository.save(assignation);
    }
    

    public Assignation updateAssignation(AssignationId id, Assignation assignation) {
        Assignation existingAssignation = assignationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignation not found"));
        existingAssignation.setDateDebut(assignation.getDateDebut());
        existingAssignation.setDateFin(assignation.getDateFin());
        return assignationRepository.save(existingAssignation);
    }

    public void deleteAssignation(AssignationId id) {
        assignationRepository.deleteById(id);
    }
}
