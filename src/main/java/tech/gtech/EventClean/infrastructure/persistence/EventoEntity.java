package tech.gtech.EventClean.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.gtech.EventClean.core.enums.TipoVento;

import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "eventos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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

    public String gerarIdentificador() {
        Random random = new Random();
        int parteNumerica = random.nextInt(10000);
        char letra1 = (char) (random.nextInt(26) + 'A');
        char letra2 = (char) (random.nextInt(26) + 'A');
        this.identificador = ""+ letra1+letra2+String.format("%04d", parteNumerica);
        return this.identificador;
    }
}