package ee.gpaas.veebipood.repository;

import ee.gpaas.veebipood.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByCategoryId(Pageable pageable, Long categoryId);
    Long id(Long id);
}
