package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.DemandeDePermission;
import ci.sndi.e_permission.services.DemandeDePermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demande-de-permissions")
public class DemandeDePermissionController {

    private final DemandeDePermissionService demandeDePermissionService;


    public DemandeDePermissionController(DemandeDePermissionService demandeDePermissionService) {
        this.demandeDePermissionService = demandeDePermissionService;
    }

    @GetMapping
    public List<DemandeDePermission> getAllDemandeDePermissions() {
        return demandeDePermissionService.getAllDemandeDePermissions();
    }

    @PostMapping
    public DemandeDePermission createDemandeDePermission(@RequestBody DemandeDePermission demandeDePermission) {
        return demandeDePermissionService.createDemandeDePermission(demandeDePermission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeDePermission> getDemandeDePermissionById(@PathVariable Long id) {
        return demandeDePermissionService.getDemandeDePermissionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeDePermission> updateDemandeDePermission(@PathVariable Long id, @RequestBody DemandeDePermission demandeDePermissionDetails) {
        return ResponseEntity.ok(demandeDePermissionService.updateDemandeDePermission(id, demandeDePermissionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemandeDePermission(@PathVariable Long id) {
        demandeDePermissionService.deleteDemandeDePermission(id);
        return ResponseEntity.noContent().build();
    }
}
