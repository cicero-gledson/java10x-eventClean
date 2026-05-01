package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.exceptions.DuplicateIdentificadorEventoException;
import tech.gtech.EventClean.core.gateway.EventoGateway;

import java.util.Random;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public Evento execute(Evento evento) {
// Código retirado, pois o identificador agora é gerado automaticamente
// fora do core e já há uma lógica para que ele não se repita
//        if (eventoGateway.identificadorEventoExiste(evento.identificador())) {
//            throw new DuplicateIdentificadorEventoException("O identificador de evento "
//                    +evento.identificador()+" já existe");
//        }
        return eventoGateway.criarEvento(evento);
    }
}
