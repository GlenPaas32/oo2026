package ee.gpaas.veebipood.repository;

import ee.gpaas.veebipood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}