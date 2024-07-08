package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.Departement;
import ci.sndi.e_permission.services.DepartementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    private final DepartementService departementService;


    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }


    @PostMapping
    public ResponseEntity<Object> createDepartement(@RequestBody List <Departement> departements ) {
        for (Departement departement : departements) {
            departementService.createDepartement(departement, departement.getDirection().getId());
        }

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        return departementService.getDepartementById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement departementDetails) {
        return ResponseEntity.ok(departementService.updateDepartement(id, departementDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return ResponseEntity.noContent().build();
    }
}
