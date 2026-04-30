package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.gateway.EventoGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway  eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
