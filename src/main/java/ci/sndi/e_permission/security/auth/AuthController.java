package ci.sndi.e_permission.security.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ci.sndi.e_permission.dto.LoginResponse;
import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.security.dto.LoginForm;
import ci.sndi.e_permission.security.dto.SignUpForm;
import ci.sndi.e_permission.security.jwt.TokenProvider;
import ci.sndi.e_permission.security.service.CreateAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CreateAccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signUp")
    public ResponseEntity<Utilisateur> createAccount(@RequestBody @Valid final SignUpForm signUpForm,
            BindingResult bindingResult) {
        if (signUpForm.getNom() == null || signUpForm.getPrenom() == null || signUpForm.getEmail() == null) {
            throw new IllegalArgumentException("Les champs nom, prénom et email ne peuvent pas être nuls.");
        }

        LOGGER.info("Account creation - User: {}", signUpForm.getNom().concat(" ").concat(signUpForm.getPrenom()));

        HttpRequestUtil.checkBindingResult(bindingResult);
        Utilisateur u = this.accountService.createAccount(signUpForm);

        LOGGER.info("Account creation - Account {} created successfully ", signUpForm.getEmail());

        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginForm loginForm, BindingResult bindingResult) {

        LOGGER.info("User login - Connecting user {}", loginForm.getEmail());

        HttpRequestUtil.checkBindingResult(bindingResult);
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));

        LOGGER.info("Authentication successful for user - {}", loginForm.getEmail());

         SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

         return ResponseEntity.ok(new LoginResponse(token, userDetails));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            LOGGER.info("User logout - Disconnecting user {}", authentication.getName());
            SecurityContextHolder.clearContext();
        } else {
            LOGGER.info("User logout - No user is currently authenticated.");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
