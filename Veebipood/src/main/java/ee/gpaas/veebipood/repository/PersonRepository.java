package ee.gpaas.veebipood.repository;

import ee.gpaas.veebipood.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Long> {
    // SELECT * FROM person WHERE email =
    Person findByEmail(String email);
}