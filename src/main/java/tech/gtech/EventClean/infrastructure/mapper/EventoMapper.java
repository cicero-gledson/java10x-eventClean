package tech.gtech.EventClean.infrastructure.mapper;

import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.infrastructure.dtos.EventoDTO;

public class EventoMapper {
    public static EventoDTO toDto(Evento evento) {
        return EventoDTO.builder()
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
    public static Evento toEntity(EventoDTO eventoDTO) {
        return Evento.builder()
                .id(eventoDTO.id())
                .nome(eventoDTO.nome())
                .descricao(eventoDTO.descricao())
                .identificador(eventoDTO.identificador())
                .dataHoraInicio(eventoDTO.dataHoraInicio())
                .dataHoraFim(eventoDTO.dataHoraFim())
                .localEvento(eventoDTO.localEvento())
                .capacidade(eventoDTO.capacidade())
                .organizador(eventoDTO.organizador())
                .tipo(eventoDTO.tipo())
                .build();
    }

}
