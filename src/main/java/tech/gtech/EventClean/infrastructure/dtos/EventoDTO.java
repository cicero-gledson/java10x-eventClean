package tech.gtech.EventClean.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import tech.gtech.EventClean.core.enums.TipoVento;

import java.time.LocalDateTime;

@Builder
public record EventoDTO(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        String localEvento,
        Integer capacidade,
        String organizador,
        TipoVento tipo
) {

}
