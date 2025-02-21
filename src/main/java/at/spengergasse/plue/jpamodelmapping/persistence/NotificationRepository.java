package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
