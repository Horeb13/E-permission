package ci.sndi.e_permission.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.sndi.e_permission.models.DroitAcces;
import ci.sndi.e_permission.models.DroitAccesId;

public interface DroitAccesRepository extends JpaRepository < DroitAcces, DroitAccesId>  {

}
