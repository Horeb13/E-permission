package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.StatutDemande;
import ci.sndi.e_permission.services.StatutDemandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statutdemandes")
public class StatutDemandeController {

    private final StatutDemandeService statutDemandeService;

    public StatutDemandeController(StatutDemandeService statutDemandeService) {
        this.statutDemandeService = statutDemandeService;
    }

    @GetMapping
    public List<StatutDemande> getAllStatutDemandes() {
        return statutDemandeService.getAllStatutDemandes();
    }

    @PostMapping
    public ResponseEntity<Object> createStatutDemande(@RequestBody List <StatutDemande> statutDemandes) {
        for (StatutDemande statutDemande : statutDemandes) {
            statutDemandeService.createStatutDemande(statutDemande);
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatutDemande> getStatutDemandeById(@PathVariable Long id) {
        StatutDemande statutDemande = statutDemandeService.getStatutDemandeById(id);
        return ResponseEntity.ok(statutDemande);

    }

    @PutMapping("/{id}")
    public ResponseEntity<StatutDemande> updateStatutDemande(@PathVariable Long id, @RequestBody StatutDemande statutDemandeDetails) {
        return ResponseEntity.ok(statutDemandeService.updateStatutDemande(id, statutDemandeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatutDemande(@PathVariable Long id) {
        statutDemandeService.deleteStatutDemande(id);
        return ResponseEntity.noContent().build();
    }
}
