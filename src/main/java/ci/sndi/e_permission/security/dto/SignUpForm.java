package ci.sndi.e_permission.security.dto;

import java.util.Set;

import ci.sndi.e_permission.models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SignUpForm {

    @NotNull(message = "Le nom ne peut pas être nul.")
    @NotEmpty(message = "Le nom ne peut pas être vide.")
    @Size(min = 3, max = 50, message = "Le nom doit contenir entre 3 et 50 caractères.")
    private String nom;

    @NotNull(message = "Le prénom ne peut pas être nul.")
    @NotEmpty(message = "Le prénom ne peut pas être vide.")
    @Size(min = 3, max = 50, message = "Le prénom doit contenir entre 3 et 50 caractères.")
    private String prenom;

    private Set<Role> roles;

    @NotNull(message = "Le mot de passe ne peut pas être nul.")
    @NotEmpty(message = "Le mot de passe ne peut pas être vide.")
    @Size(min = 6, max = 40, message = "Le mot de passe doit contenir entre 6 et 40 caractères.")
    private String password;

    @Email(message = "L'adresse email doit être valide.")
    @NotNull(message = "L'adresse email ne peut pas être nulle.")
    @NotEmpty(message = "L'adresse email ne peut pas être vide.")
    private String email;

    private String departement;
}
