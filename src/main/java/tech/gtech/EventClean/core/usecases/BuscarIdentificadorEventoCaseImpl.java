package tech.gtech.EventClean.core.usecases;

import jdk.jfr.Event;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.exceptions.EventoNaoEncontradoException;
import tech.gtech.EventClean.core.gateway.EventoGateway;

public class BuscarIdentificadorEventoCaseImpl implements BuscarIdentificadorEventoCase {
    private final EventoGateway eventoGateway;

    public BuscarIdentificadorEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarIdentificadorEvento(identificador).orElseThrow(
                () -> new EventoNaoEncontradoException("O evento com identificador "+identificador+" não foi encontrado")
        );
    }
}
