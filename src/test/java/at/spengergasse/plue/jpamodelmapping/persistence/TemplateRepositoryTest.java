package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Template;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static at.spengergasse.plue.jpamodelmapping.TestFixtures.template;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TemplateRepositoryTest {
    @Autowired
    private TemplateRepository templateRepository;

    @Test
    void ensureSaveAndReadWorks() {
        Template template = template();
        var saved = templateRepository.saveAndFlush(template);
        assertThat(saved).isSameAs(template);
        assertThat(saved.getId()).isNotNull();
    }
}
