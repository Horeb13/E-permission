package ci.sndi.e_permission.controllers;

import ci.sndi.e_permission.models.StatutNotification;
import ci.sndi.e_permission.services.StatutNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statutnotifications")
public class StatutNotificationController {

    private final StatutNotificationService statutNotificationService;

    public StatutNotificationController(StatutNotificationService statutNotificationService) {
        this.statutNotificationService = statutNotificationService;
    }

    @GetMapping
    public List<StatutNotification> getAllStatutNotifications() {
        return statutNotificationService.getAllStatutNotifications();
    }

    @PostMapping
    public ResponseEntity<Object> createStatutNotification(@RequestBody List <StatutNotification> statutNotifications) {
        for (StatutNotification statutNotification : statutNotifications) {
            statutNotificationService.createStatutNotification(statutNotification);
        }
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatutNotification> getStatutNotificationById(@PathVariable Long id) {
        StatutNotification statutNotification = statutNotificationService.getStatutNotificationById(id);
        return ResponseEntity.ok(statutNotification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatutNotification> updateStatutNotification(@PathVariable Long id, @RequestBody StatutNotification statutNotificationDetails) {
        return ResponseEntity.ok(statutNotificationService.updateStatutNotification(id, statutNotificationDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatutNotification(@PathVariable Long id) {
        statutNotificationService.deleteStatutNotification(id);
        return ResponseEntity.noContent().build();
    }
}
