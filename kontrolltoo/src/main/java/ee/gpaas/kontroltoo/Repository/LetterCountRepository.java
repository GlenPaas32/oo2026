package ee.gpaas.kontroltoo.Repository;

import ee.gpaas.kontroltoo.entity.LetterCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterCountRepository extends JpaRepository<LetterCount, Long> {
}
