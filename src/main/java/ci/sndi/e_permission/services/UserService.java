package ci.sndi.e_permission.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.repositories.RoleRepository;
import ci.sndi.e_permission.repositories.UtilisateurRepository;
import ci.sndi.e_permission.security.Security;
import ci.sndi.e_permission.security.dto.SignUpForm;
import ci.sndi.e_permission.models.Role;
import jakarta.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    
    private final UtilisateurRepository repo;
    private final DepartementService departementService;
    private final Security security;
    private final RoleRepository roleRepository;

    public Utilisateur findUser(Long id) {
        return findById(id);
    }

    public Optional<Utilisateur> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Utilisateur findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Set<Role> addRoleToSet(Set <Long> userRoles) {
        // Initialize a set of roles
        Set<Role> roles = new HashSet<>();
    
        // Get the role from roleService

        userRoles.forEach(
            userRole -> {
                Role role = roleRepository.findById(userRole).orElseThrow(
                    ()-> new IllegalStateException("Role not found " + userRole)
                );
                roles.add(role);
            }
        );
        
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
            user.setRoles(addRoleToSet(request.getRoles()));
            log.info(request.getRoles().toString());
            log.info(user.getRoles().toString());
            user.setEnabled(true);
            user = repo.save(user);
        }
        return user;
    }

}
