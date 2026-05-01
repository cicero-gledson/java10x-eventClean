package tech.gtech.EventClean.core.gateway;

import jdk.jfr.Event;
import tech.gtech.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {
    Evento criarEvento (Evento evento);
    Optional<Evento> buscarEvento (Long id);
    List<Evento> buscarTodosEventos();
    Boolean identificadorEventoExiste(String identificador);
    Optional<Evento> buscarIdentificadorEvento(String identificador);
}
