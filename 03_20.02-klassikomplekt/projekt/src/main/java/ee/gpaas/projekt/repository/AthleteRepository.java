package ee.gpaas.projekt.repository;

import ee.gpaas.projekt.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}