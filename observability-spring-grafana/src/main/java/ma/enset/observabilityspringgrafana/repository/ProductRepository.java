package ma.enset.observabilityspringgrafana.repository;

import ma.enset.observabilityspringgrafana.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
