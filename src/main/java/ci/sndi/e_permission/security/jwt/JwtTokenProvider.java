package ci.sndi.e_permission.security.jwt;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import ci.sndi.e_permission.security.service.UserPrinciple;
import ci.sndi.e_permission.security.auth.HttpRequestUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;

@Component
public class JwtTokenProvider implements TokenProvider {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${app.jwt.secretKey}")
	private String jwtSecret;

	@Value("${app.jwt.expirationTime}")
	private int jwtExpiration;

	@Override
	public boolean validateToken(String jwt) {
		LOGGER.info("Validation of token - {}", jwt);
		try {
			parseClaims(jwt);

		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {

			LOGGER.info("Validation of token failed - {}", jwt);
			return false;
		}

		LOGGER.info("Validation of token successfull - {}", jwt);
		return true;
	}

	@Override
	public String getUsernameFromToken(String jwt) {

		return tokenClaims(jwt).getSubject();
	}

	@Override
	public String generateToken(Authentication authentication) {

		LOGGER.info("Genration of token for - {}", authentication.getPrincipal());

		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
		 // Récupérer les authorities de l'utilisateur
		 List<String> roles = userPrincipal.getAuthorities().stream()
		 .map(GrantedAuthority::getAuthority)
		 .toList(); 

		Date exprirationTime = tokenExpirationTime();

		LOGGER.info("Genration of token successfull. Expire at - {}", exprirationTime);

		return Jwts
				.builder()
				.claim("roles", roles)
				.setSubject((userPrincipal.getUsername() ))
				.setIssuedAt(new Date())
				.setExpiration(exprirationTime)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	@Override
	public String getJwt(HttpServletRequest request) {

		String authHeader = HttpRequestUtil.getAuthorization(request);
		if (authHeader != null && authHeader.startsWith(JwtTokenFilter.TOKEN_PREFIX))
			return authHeader.replace(JwtTokenFilter.TOKEN_PREFIX, "");

		return null;
	}

	private Date tokenExpirationTime() {
		return new Date(Calendar.getInstance().getTimeInMillis() + (jwtExpiration * 60 * 1000));
	}

	@SuppressWarnings("unused")
	private void canRefreshToken(String currentToken) {

		try {
			Date date = tokenClaims(currentToken).getExpiration();
			System.out.println("Expiration date is" + date);
			if (date.before(new Date()))
				throw new InvalidParameterException("Cannot refresh not expired token");

		} catch (ExpiredJwtException e) {
			System.out.println("Token is expired, can be refreshed");
		}

	}

	private Jws<Claims> parseClaims(String jwt) {
		System.out.println(jwt);
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
	}

	private Claims tokenClaims(String currentToken) {
		return parseClaims(currentToken).getBody();
	}

	


}
