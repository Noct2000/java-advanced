package kvasha.university.java.advanced.repository;

import kvasha.university.java.advanced.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select count(p) from Product p")
    Integer getCountOfAllProducts();
}
