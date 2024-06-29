package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.StatutNotification;
import ci.sndi.e_permission.repositories.StatutNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutNotificationService {

    @Autowired
    private StatutNotificationRepository statutNotificationRepository;

    public List<StatutNotification> getAllStatutNotifications() {
        return statutNotificationRepository.findAll();
    }

    public StatutNotification getStatutNotificationById(Long id) {
        return statutNotificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StatutNotification not found"));
    }

    public StatutNotification createStatutNotification(StatutNotification statutNotification) {
        return statutNotificationRepository.save(statutNotification);
    }

    public StatutNotification updateStatutNotification(Long id, StatutNotification statutNotification) {
        StatutNotification existingStatutNotification = statutNotificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StatutNotification not found"));
        existingStatutNotification.setCode(statutNotification.getCode());
        existingStatutNotification.setLibelle(statutNotification.getLibelle());
        return statutNotificationRepository.save(existingStatutNotification);
    }

    public void deleteStatutNotification(Long id) {
        statutNotificationRepository.deleteById(id);
    }
}
