package es.mercadona.duffbeer.repository;

import es.mercadona.duffbeer.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Proveedor, Long> {
}
