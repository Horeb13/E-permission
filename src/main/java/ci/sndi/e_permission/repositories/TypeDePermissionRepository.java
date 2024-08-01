package ci.sndi.e_permission.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.TypeDePermission;



@Repository
public interface TypeDePermissionRepository extends JpaRepository <TypeDePermission, Long>{
    Optional <TypeDePermission>  findByNom(String nom);

}
