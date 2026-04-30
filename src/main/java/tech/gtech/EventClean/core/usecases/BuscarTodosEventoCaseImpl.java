package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarTodosEventoCaseImpl implements BuscarTodosEventoCase {
    private final EventoGateway eventoGateway;

    public BuscarTodosEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarTodosEventos();
    }
}
