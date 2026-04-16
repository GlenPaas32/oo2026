package ee.gpaas.veebipood.repository;

import ee.gpaas.veebipood.entity.Category;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<@NonNull Category,@NonNull Long> {
}