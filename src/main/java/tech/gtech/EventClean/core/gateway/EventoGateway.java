package tech.gtech.EventClean.core.gateway;

import tech.gtech.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {
    Evento criarEvento (Evento evento);
    Evento buscarEvento (Long id);
    List<Evento> buscarTodosEventos();
}
