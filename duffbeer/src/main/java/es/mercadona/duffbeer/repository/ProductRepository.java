package es.mercadona.duffbeer.repository;

import es.mercadona.duffbeer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where lower(p.categoria)=lower(:categoria) order by p.id")
    List<Product> findByCategoria(@Param("categoria") String categoria);

    @Query(value = "select p from Product p where lower(p.marca)=lower(:marca) order by p.categoria, p.id")
    List<Product> findByMarca(@Param("marca") String marca);

    @Query(value = "select p from Product p order by p.categoria, p.id")
    List<Product> findAll();
}
