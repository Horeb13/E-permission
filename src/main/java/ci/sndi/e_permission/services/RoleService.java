package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Role;
import ci.sndi.e_permission.models.TypeRole;
import ci.sndi.e_permission.repositories.RoleRepository;
import ci.sndi.e_permission.repositories.TypeRoleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final TypeRoleRepository typeRoleRepository;

    public RoleService(RoleRepository roleRepository, TypeRoleRepository typeRoleRepository) {
        this.roleRepository = roleRepository;
        this.typeRoleRepository = typeRoleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role, Long idTypeRole) {
        TypeRole typeRole = typeRoleRepository.findById(idTypeRole)
                            .orElseThrow(() -> new IllegalArgumentException("TyRole not found"));
        role.setTypeRole(typeRole);
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

    public Role getRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
    }

    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        role.setLibelle(roleDetails.getLibelle());
        role.setDateCreation(roleDetails.getDateCreation());
        role.setDateModification(roleDetails.getDateModification());
        role.setModifiePar(roleDetails.getModifiePar());

        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
