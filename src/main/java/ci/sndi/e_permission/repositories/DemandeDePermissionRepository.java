package ci.sndi.e_permission.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.DemandeDePermission;
import ci.sndi.e_permission.models.Utilisateur;


@Repository
public interface DemandeDePermissionRepository extends JpaRepository <DemandeDePermission, Long>{

    Optional <DemandeDePermission> findByUtilisateur(Utilisateur utilisateur);

}
