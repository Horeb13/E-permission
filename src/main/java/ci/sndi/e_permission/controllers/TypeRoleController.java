package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.TypeRole;
import ci.sndi.e_permission.services.TypeRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeroles")
public class TypeRoleController {
    
    private final TypeRoleService typeRoleService;

    
    public TypeRoleController(TypeRoleService typeRoleService) {
        this.typeRoleService = typeRoleService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_standard1')")
    public List<TypeRole> getAllTypeRoles() {
        return typeRoleService.getAllTypeRoles();
    }

    @PostMapping
    //@PreAuthorize("hasRole('Directeur')")
    public ResponseEntity<Object> createTypeRole(@RequestBody List <TypeRole> typeRoles) {
        for (TypeRole typeRole : typeRoles) {
            typeRoleService.createTypeRole(typeRole);
        }
        return ResponseEntity.status(201).build();
    }

    @PreAuthorize("hasRole('ROLE_standard1')")
    @GetMapping("/{id}")
    public ResponseEntity<TypeRole> getTypeRoleById(@PathVariable Long id) {
        TypeRole typeRole = typeRoleService.getTypeRoleById(id);
        return ResponseEntity.ok(typeRole);
    }

    @PutMapping("/{id}")
    public TypeRole updateTypeRole(@PathVariable Long id, @RequestBody TypeRole typeRoleDetails) {
        return typeRoleService.updateTypeRole(id, typeRoleDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeRole(@PathVariable Long id) {
        typeRoleService.deleteTypeRole(id);
        return ResponseEntity.noContent().build();
    }
}
