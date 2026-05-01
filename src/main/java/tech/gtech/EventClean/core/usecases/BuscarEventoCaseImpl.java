package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.exceptions.EventoNaoEncontradoException;
import tech.gtech.EventClean.core.gateway.EventoGateway;

public class BuscarEventoCaseImpl implements BuscarEventoCase {
    private final EventoGateway eventoGateway;

    public BuscarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(Long id) {
        return eventoGateway.buscarEvento(id).orElseThrow(
                () -> new EventoNaoEncontradoException("O evento com id "+id+" não foi encontrado")
        );
    }
}
