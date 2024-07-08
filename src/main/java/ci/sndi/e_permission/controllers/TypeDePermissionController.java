package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.TypeDePermission;
import ci.sndi.e_permission.services.TypeDePermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typedpermissions")
public class TypeDePermissionController {

    private final TypeDePermissionService typeDePermissionService;

    public TypeDePermissionController(TypeDePermissionService typeDePermissionService) {
        this.typeDePermissionService = typeDePermissionService;
    }

    @GetMapping
    public List<TypeDePermission> getAllTypeDePermissions() {
        return typeDePermissionService.getAllTypeDePermissions();
    }

    @PostMapping
    public ResponseEntity<Object> createTypeDePermission(@RequestBody List <TypeDePermission> typeDePermissions) {
        for (TypeDePermission typeDePermission : typeDePermissions) {
            typeDePermissionService.createTypeDePermission(typeDePermission);
        }
        return ResponseEntity.status(201).build() ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDePermission> getTypeDePermissionById(@PathVariable Long id) {
        return typeDePermissionService.getTypeDePermissionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDePermission> updateTypeDePermission(@PathVariable Long id, @RequestBody TypeDePermission typeDePermissionDetails) {
        return ResponseEntity.ok(typeDePermissionService.updateTypeDePermission(id, typeDePermissionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeDePermission(@PathVariable Long id) {
        typeDePermissionService.deleteTypeDePermission(id);
        return ResponseEntity.noContent().build();
    }
}
