package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.PieceJointe;
import ci.sndi.e_permission.services.PieceJointeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piecejointes")
public class PieceJointeController {

    private final PieceJointeService pieceJointeService;

    public PieceJointeController(PieceJointeService pieceJointeService) {
        this.pieceJointeService = pieceJointeService;
    }

    @GetMapping
    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeService.getAllPieceJointes();
    }

    @PostMapping
    public ResponseEntity<Object> createPieceJointe(@RequestBody List <PieceJointe> pieceJointes) {
        for (PieceJointe pieceJointe : pieceJointes) {
            pieceJointeService.createPieceJointe(pieceJointe);
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceJointe> getPieceJointeById(@PathVariable Long id) {
        PieceJointe pieceJointe = pieceJointeService.getPieceJointeById(id);
        return ResponseEntity.ok(pieceJointe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceJointe> updatePieceJointe(@PathVariable Long id, @RequestBody PieceJointe pieceJointeDetails) {
        return ResponseEntity.ok(pieceJointeService.updatePieceJointe(id, pieceJointeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceJointe(@PathVariable Long id) {
        pieceJointeService.deletePieceJointe(id);
        return ResponseEntity.noContent().build();
    }
}

