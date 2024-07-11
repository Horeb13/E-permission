package ci.sndi.e_permission.security.auth;

import org.springframework.validation.BindingResult;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

public class HttpRequestUtil {
	private HttpRequestUtil() {
	}

	@SuppressWarnings("all")
	public static void checkBindingResult(BindingResult bindingResult) {

		if (bindingResult != null && bindingResult.hasErrors() && bindingResult.getFieldError() != null) {
			String errorMessage = bindingResult.getFieldError().getField() + " "
					+ bindingResult.getFieldError().getDefaultMessage();
			throw new ValidationException(errorMessage);
		}
	}

	public static String getAuthorization(HttpServletRequest request) {
		return request.getHeader("Authorization");
	}
}

