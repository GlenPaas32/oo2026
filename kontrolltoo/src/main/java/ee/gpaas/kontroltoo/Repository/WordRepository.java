package ee.gpaas.kontroltoo.Repository;

import ee.gpaas.kontroltoo.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
