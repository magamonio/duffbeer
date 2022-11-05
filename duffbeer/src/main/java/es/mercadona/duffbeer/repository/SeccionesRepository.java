package es.mercadona.duffbeer.repository;

import es.mercadona.duffbeer.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Provider;

@Repository
public interface SeccionesRepository extends JpaRepository<Seccion, Long> {
}
