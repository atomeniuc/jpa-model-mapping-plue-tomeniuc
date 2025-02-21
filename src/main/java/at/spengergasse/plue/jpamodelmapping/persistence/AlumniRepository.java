package at.spengergasse.plue.jpamodelmapping.persistence;

import at.spengergasse.plue.jpamodelmapping.domain.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Long> {
}
