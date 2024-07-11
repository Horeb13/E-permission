package ci.sndi.e_permission.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.Role;


@Repository
public interface RoleRepository extends JpaRepository <Role, Long>{

    Optional<Role> findByLibelle(String roleName);

}
