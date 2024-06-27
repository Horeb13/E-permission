package ci.sndi.e_permission.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ci.sndi.e_permission.models.Assignation;
import ci.sndi.e_permission.models.AssignationId;

@Repository
public interface AssignationRepository extends JpaRepository<Assignation, AssignationId> {
    
}