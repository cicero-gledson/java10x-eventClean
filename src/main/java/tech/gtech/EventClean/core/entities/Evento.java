package tech.gtech.EventClean.core.entities;

import tech.gtech.EventClean.core.enums.TipoVento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        String local,
        String organizador,
        TipoVento tipo
) {
}
