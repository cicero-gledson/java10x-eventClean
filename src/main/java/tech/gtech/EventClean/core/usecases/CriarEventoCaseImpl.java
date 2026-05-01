package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.gateway.EventoGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(Evento evento) {
//        if (eventoGateway.identificadorEventoExiste(evento.identificador())) {
//            throw new DuplicateIdentificadorEventoException("O identificador de evento "
//                    +evento.identificador()+" já existe");
//        }

        while (eventoGateway.identificadorEventoExiste(evento.identificador())){
            evento = evento.novoIdentificador();
        }
        return eventoGateway.criarEvento(evento);
    }
}
