package ci.sndi.e_permission.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.StatutDemande;


@Repository
public interface StatutDemandeRepository extends JpaRepository <StatutDemande, Long>{

}
