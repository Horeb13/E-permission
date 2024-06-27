package ci.sndi.e_permission.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.Notification;


@Repository
public interface NotificationRepository extends JpaRepository <Notification, Long>{

}
