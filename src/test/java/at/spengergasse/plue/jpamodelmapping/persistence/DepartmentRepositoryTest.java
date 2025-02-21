package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static at.spengergasse.plue.jpamodelmapping.TestFixtures.department;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void ensureSaveAndReadWorks() {
        Department department = department();
        var saved = departmentRepository.saveAndFlush(department);
        assertThat(saved).isSameAs(department);
        assertThat(saved.getId()).isNotNull();
    }
}
