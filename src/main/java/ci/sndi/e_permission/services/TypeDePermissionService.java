package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.TypeDePermission;
import ci.sndi.e_permission.repositories.TypeDePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDePermissionService {

    private final TypeDePermissionRepository typeDePermissionRepository;


    public TypeDePermissionService(TypeDePermissionRepository typeDePermissionRepository) {
        this.typeDePermissionRepository = typeDePermissionRepository;
    }

    public List<TypeDePermission> getAllTypeDePermissions() {
        return typeDePermissionRepository.findAll();
    }

    public TypeDePermission createTypeDePermission(TypeDePermission typeDePermission) {
        return typeDePermissionRepository.save(typeDePermission);
    }

    public Optional<TypeDePermission> getTypeDePermissionById(Long id) {
        return typeDePermissionRepository.findById(id);
    }

    public TypeDePermission updateTypeDePermission(Long id, TypeDePermission typeDePermissionDetails) {
        TypeDePermission typeDePermission = typeDePermissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Type de permission non trouvé avec l'ID : " + id));

        typeDePermission.setNom(typeDePermissionDetails.getNom());
        typeDePermission.setDescription(typeDePermissionDetails.getDescription());
        typeDePermission.setDuree(typeDePermissionDetails.getDuree());
        // Mettez à jour d'autres champs selon vos besoins

        return typeDePermissionRepository.save(typeDePermission);
    }

    public void deleteTypeDePermission(Long id) {
        typeDePermissionRepository.deleteById(id);
    }
}
