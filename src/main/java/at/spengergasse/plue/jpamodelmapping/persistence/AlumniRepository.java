package at.spengergasse.plue.jpamodelmapping.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniRepository extends JpaRepository<AlumniRepository, Long> {
}
