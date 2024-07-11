package ci.sndi.e_permission.security.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import ci.sndi.e_permission.models.Utilisateur;


public interface UserJpaRepository extends JpaRepository<Utilisateur, Long>{

 
	boolean existsByEmail(String email);

	Utilisateur getByEmail(String email);

	Utilisateur findByEmail(String email); 


}
