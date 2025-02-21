package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Token;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TokenRepositoryTest {
    @Autowired
    TokenRepository repository;

    @Test
    void ensureSaveAndReadWorks() {
        Token a = Token.builder().build();
        var saved = repository.saveAndFlush(a);

        assertThat(saved).isSameAs(a);
        assertThat(saved.getId()).isNotNull();
    }
}

