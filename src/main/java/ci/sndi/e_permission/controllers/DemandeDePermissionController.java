package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.dto.DemandeDePermissionDto;
import ci.sndi.e_permission.models.DemandeDePermission;
import ci.sndi.e_permission.models.Utilisateur;
import ci.sndi.e_permission.services.DemandeDePermissionService;
import ci.sndi.e_permission.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeDePermissionController {

    private final DemandeDePermissionService demandeDePermissionService;
    private final UserService userService;


    public DemandeDePermissionController(DemandeDePermissionService demandeDePermissionService, UserService userService) {
        this.demandeDePermissionService = demandeDePermissionService;
        this.userService = userService;
    }

    @GetMapping
    public List<DemandeDePermission> getAllDemandeDePermissions() {
        return demandeDePermissionService.getAllDemandeDePermissions();
    }

    @PostMapping
    public DemandeDePermission createDemandeDePermission(@RequestBody DemandeDePermissionDto demandeDePermissionDto) {
        return demandeDePermissionService.createDemandeDePermission(demandeDePermissionDto);
    }

    @GetMapping("all/{id}")
    public ResponseEntity<DemandeDePermission> getDemandeDePermissionById(@PathVariable Long id) {
        return demandeDePermissionService.getDemandeDePermissionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{userEmail}") 
    public List <DemandeDePermission> getDemandeDePermissionByUser(@PathVariable String userEmail){

        Utilisateur user = userService.findByEmail(userEmail).orElseThrow(
            () -> new IllegalArgumentException("User not found with email: " + userEmail)
        );
        return demandeDePermissionService.getDemandeDePermissionByUser(user);
                                       
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
