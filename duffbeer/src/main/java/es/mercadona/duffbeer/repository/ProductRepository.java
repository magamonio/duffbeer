package es.mercadona.duffbeer.repository;

import es.mercadona.duffbeer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p order by p.seccion.name, p.id")
    List<Product> findAll();

}
