package ci.sndi.e_permission.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class LoginResponse {
    private String token;
    private UserDetails userDetails;

    public LoginResponse(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return token;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
