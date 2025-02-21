package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Alumni;
import at.spengergasse.plue.jpamodelmapping.domain.Template;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static at.spengergasse.plue.jpamodelmapping.TestFixtures.alumni;
import static at.spengergasse.plue.jpamodelmapping.TestFixtures.template;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AlumniRepositoryTest {
    @Autowired
    private AlumniRepository alumniRepository;

    @Test
    void ensureSaveAndReadWorks() {
        Alumni alumni = alumni();
        var saved = alumniRepository.saveAndFlush(alumni);
        assertThat(saved).isSameAs(alumni);
        assertThat(saved.getId()).isNotNull();
    }
}
