package ci.sndi.e_permission.security.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String password;
}