package ee.gpaas.autod.repository;

import ee.gpaas.autod.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Long> {
}