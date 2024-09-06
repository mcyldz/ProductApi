package org.mcyldz.productapi.repository;
import org.mcyldz.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //Spring Data JPA - Query Creation from Method Names
    List<Product> findByName(String name);

    //JPQL
    @Query("SELECT e FROM Product e WHERE e.productId =:productId and e.name =:name")
    Product getProduct(@Param("productId") int productId, @Param("name") String name);

    //Native SQL Query
    @Query(value = "SELECT * FROM Product e WHERE e.product_id = :productId and e.product_name = :name", nativeQuery = true)
    Product getProductByNativeQuery(@Param("productId") int productId, @Param("name") String name);

}
