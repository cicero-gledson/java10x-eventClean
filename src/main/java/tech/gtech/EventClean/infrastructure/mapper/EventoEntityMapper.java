package tech.gtech.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.enums.TipoVento;
import tech.gtech.EventClean.infrastructure.persistence.EventoEntity;

import java.time.LocalDateTime;

@Component
public class EventoEntityMapper {

    public static EventoEntity toEventoEntity(Evento evento) {
        return EventoEntity.builder()
                .id(evento.id())
                .nome(evento.nome())
                .descricao(evento.descricao())
                .identificador(evento.identificador())
                .dataHoraInicio(evento.dataHoraInicio())
                .dataHoraFim(evento.dataHoraFim())
                .localEvento(evento.localEvento())
                .capacidade(evento.capacidade())
                .organizador(evento.organizador())
                .tipo(evento.tipo())
                .build();
    }
    public static Evento toDomain(EventoEntity eventoEntity) {
        return new Evento.Builder()
                .id(eventoEntity.getId())
                .nome(eventoEntity.getNome())
                .descricao(eventoEntity.getDescricao())
                .identificador(eventoEntity.getIdentificador())
                .dataHoraInicio(eventoEntity.getDataHoraInicio())
                .dataHoraFim(eventoEntity.getDataHoraFim())
                .localEvento(eventoEntity.getLocalEvento())
                .capacidade(eventoEntity.getCapacidade())
                .organizador(eventoEntity.getOrganizador())
                .tipo(eventoEntity.getTipo())
                .build();
    }
}
