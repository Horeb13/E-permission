package ci.sndi.e_permission.security;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PasswordCryptor implements Security{

	private final org.springframework.security.crypto.password.PasswordEncoder encoder;

	@Override
	public String cryptPassword(String password) {
		return encoder.encode(password);
	} 
	
}

