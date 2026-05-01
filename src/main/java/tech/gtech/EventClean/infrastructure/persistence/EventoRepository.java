package tech.gtech.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    Boolean existsByIdentificador(String identificador);
    Optional<EventoEntity> findByIdentificador(String identificador);
}
