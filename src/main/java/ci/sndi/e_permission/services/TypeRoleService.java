package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.TypeRole;
import ci.sndi.e_permission.repositories.TypeRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRoleService {
    private final TypeRoleRepository typeRoleRepository;


    public TypeRoleService(TypeRoleRepository typeRoleRepository) {
        this.typeRoleRepository = typeRoleRepository;
    }

    public List<TypeRole> getAllTypeRoles() {
        return typeRoleRepository.findAll();
    }

    public TypeRole createTypeRole(TypeRole typeRole) {
        return typeRoleRepository.save(typeRole);
    }

    public TypeRole getTypeRoleById(Long id) {
        return typeRoleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TypeRole not found"));
    }

    public TypeRole updateTypeRole(Long id, TypeRole typeRoleDetails) {
        TypeRole typeRole = typeRoleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TypeRole not found"));

        typeRole.setLibelle(typeRoleDetails.getLibelle());
        typeRole.setModifiePar(typeRoleDetails.getModifiePar());

        return typeRoleRepository.save(typeRole);
    }

    public void deleteTypeRole(Long id) {
        typeRoleRepository.deleteById(id);
    }
}
