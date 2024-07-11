package ci.sndi.e_permission.security.jwt;
import java.io.IOException;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import ci.sndi.e_permission.security.SecurityHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenFilter extends OncePerRequestFilter{

	
	private final TokenProvider tokenProvider;
	private final SecurityHelper securityHelper;

    
	
	static final String TOKEN_PREFIX = "Bearer ";
	
 
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = tokenProvider.getJwt(request);
		
		if(jwt != null && tokenProvider.validateToken(jwt)) {
			setAuthenticationContext(jwt, request);
		}
		
		filterChain.doFilter(request, response);
	}
	
	
	private void setAuthenticationContext(String jwt, HttpServletRequest request) {
		
		String userName = tokenProvider.getUsernameFromToken(jwt);
		UsernamePasswordAuthenticationToken authentication =  securityHelper.setAuthenticationToken(userName, request);
		SecurityContextHolder
			.getContext()
			.setAuthentication(authentication);
	}

	
	
}
