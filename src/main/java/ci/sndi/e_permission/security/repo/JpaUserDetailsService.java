package ci.sndi.e_permission.security.repo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.security.service.UserPrinciple;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

	private final UserJpaRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Utilisateur user = repository.getByEmail(email);
		if (user == null)
			throw new EntityNotFoundException("User Not Found with -> username or email : " + email);

		return UserPrinciple.build(user);
	}

}
