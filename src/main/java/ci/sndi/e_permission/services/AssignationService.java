package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Assignation;
import ci.sndi.e_permission.models.AssignationId;
import ci.sndi.e_permission.repositories.AssignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignationService {

    @Autowired
    private AssignationRepository assignationRepository;

    public List<Assignation> getAllAssignations() {
        return assignationRepository.findAll();
    }

    public Assignation getAssignationById(AssignationId id) {
        return assignationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignation not found"));
    }

    public Assignation createAssignation(Assignation assignation) {
        return assignationRepository.save(assignation);
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
