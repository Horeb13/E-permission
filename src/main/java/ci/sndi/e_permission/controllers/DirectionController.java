package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.Direction;
import ci.sndi.e_permission.services.DirectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directions")
public class DirectionController {

    private final DirectionService directionService;

    public DirectionController(DirectionService directionService) {
        this.directionService = directionService;
    }

    @GetMapping
    public List<Direction> getAllDirections() {
        return directionService.getAllDirections();
    }

    @PostMapping
    public ResponseEntity<Object> createDirection(@RequestBody List <Direction> directions) {
        for (Direction direction : directions) {
            directionService.createDirection(direction);
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direction> getDirectionById(@PathVariable Long id) {
        return directionService.getDirectionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direction> updateDirection(@PathVariable Long id, @RequestBody Direction directionDetails) {
        return ResponseEntity.ok(directionService.updateDirection(id, directionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirection(@PathVariable Long id) {
        directionService.deleteDirection(id);
        return ResponseEntity.noContent().build();
    }
}
