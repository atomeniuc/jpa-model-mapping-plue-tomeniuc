package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Alumni;
import at.spengergasse.plue.jpamodelmapping.domain.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static at.spengergasse.plue.jpamodelmapping.TestFixtures.alumni;
import static at.spengergasse.plue.jpamodelmapping.TestFixtures.notification;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class NotificationRepositoryTest {
    @Autowired
    private NotificationRepository notificationRepository;

    @Test
    void ensureSaveAndReadWorks() {
        Notification notification = notification();
        var saved = notificationRepository.saveAndFlush(notification);
        assertThat(saved).isSameAs(notification);
        assertThat(saved.getId()).isNotNull();
    }
}
