package ci.sndi.e_permission.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;


import org.springframework.stereotype.Service;

import ci.sndi.e_permission.models.Role;
import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.repositories.UtilisateurRepository;
import ci.sndi.e_permission.security.Security;
import ci.sndi.e_permission.security.dto.SignUpForm;
import jakarta.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    
    private final UtilisateurRepository repo;
    private final DepartementService departementService;
    private final RoleService roleService;
    private final Security security;

    public Utilisateur findUser(Long id) {
        return findById(id);
    }

    public Utilisateur findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Set<Role> addRoleToSet() {
        // Initialize a set of roles
        Set<Role> roles = new HashSet<>();
    
        // Get the role from roleService
        Role role = roleService.getRoleByLibelle("standard1");
    
        // Add the retrieved role to the set
        roles.add(role);
    
        // Now roles set contains the role retrieved from roleService
        return roles;
    }

    @Override
    public Utilisateur createUser(SignUpForm request) {
        Utilisateur user = new Utilisateur();
        


        if (user != null) {
            log.info("UserService Call---- createUser ------");
            user.setNom(request.getNom());
            user.setPrenom(request.getPrenom());
            user.setEmail(request.getEmail());
            user.setMotDePasse(security.cryptPassword(request.getPassword()));
            user.setDepartement(departementService.getDepartementByCode(request.getDepartement()));
            user.setRoles(addRoleToSet());
            user.setEnabled(true);
            user = repo.save(user);
        }
        return user;
    }

}
