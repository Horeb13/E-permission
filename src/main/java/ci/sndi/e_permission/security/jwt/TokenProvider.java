package ci.sndi.e_permission.security.jwt;



import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;


public interface TokenProvider {

	public boolean validateToken(String token);
	public  String getUsernameFromToken(String token);
	public String generateToken(Authentication authentication);
	public String getJwt(HttpServletRequest request);
	
}
