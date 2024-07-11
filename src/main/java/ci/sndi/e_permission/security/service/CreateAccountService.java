package ci.sndi.e_permission.security.service;

import org.springframework.stereotype.Service;

import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.security.AccountCreationException;
import ci.sndi.e_permission.security.dto.SignUpForm;
import ci.sndi.e_permission.security.repo.UserJpaRepository;
import ci.sndi.e_permission.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAccountService {

	private final UserJpaRepository accounrRepository;
	private final UserService service;

	public Utilisateur createAccount(final SignUpForm request) {

		if (accounrRepository.existsByEmail(request.getEmail())) {
			throw new AccountCreationException("L'adresse mail est déja utilisé par un autre utilisateur");
		}

		return service.createUser(request);
	}

}
