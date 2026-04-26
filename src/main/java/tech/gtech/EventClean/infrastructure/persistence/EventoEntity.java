package tech.gtech.EventClean.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.gtech.EventClean.core.enums.TipoVento;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String localEvento;
    private Integer capacidade;
    private String organizador;
    @Enumerated(EnumType.STRING)
    private TipoVento tipo;

}