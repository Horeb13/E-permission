package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.security.dto.SignUpForm;

public interface IUserService {

    public Utilisateur createUser(SignUpForm request);

    public Utilisateur findUser(Long id);

    //public boolean isUserAcheter(Long idUser);

    //public boolean isUserLivreur(Long idUser);

    //public boolean isUserVendeur(Long idUser);

}
