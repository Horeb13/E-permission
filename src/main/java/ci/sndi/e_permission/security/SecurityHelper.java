package ci.sndi.e_permission.security;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class SecurityHelper {
	
	
	private UserDetailsService userDetailsService;
	
	public SecurityHelper(UserDetailsService service) {
		this.userDetailsService = service;
	}

	public  UsernamePasswordAuthenticationToken setAuthenticationToken(String userName, HttpServletRequest  request) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return authentication;
	}
}
