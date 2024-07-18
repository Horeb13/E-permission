package ci.sndi.e_permission.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.TypeRole;


@Repository
public interface TypeRoleRepository extends JpaRepository <TypeRole, Long> {

    Optional<TypeRole> findByLibelle(String Libelle);

}
