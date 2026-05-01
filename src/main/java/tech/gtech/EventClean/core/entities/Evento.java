package tech.gtech.EventClean.core.entities;

import tech.gtech.EventClean.core.enums.TipoVento;

import java.time.LocalDateTime;
import java.util.Random;

public record Evento(
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

    public static String gerarIdentificador() {
        Random random = new Random();
        int parteNumerica = random.nextInt(10000);
        char letra1 = (char) (random.nextInt(26) + 'A');
        char letra2 = (char) (random.nextInt(26) + 'A');
        return ""+ letra1+letra2+String.format("%04d", parteNumerica);
    }

    public Evento novoIdentificador() {
        return new Evento(id,
                nome,
                descricao,
                gerarIdentificador(),
                dataHoraInicio,
                dataHoraFim,
                localEvento,
                capacidade,
                organizador,
                tipo);
    }

    public static class Builder{
        private Long id;
        private String nome;
        private String descricao;
        private String identificador;
        private LocalDateTime dataHoraInicio;
        private LocalDateTime dataHoraFim;
        private String localEvento;
        private Integer capacidade;
        private String organizador;
        private TipoVento tipo;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder identificador(String identificador) {
            this.identificador = identificador;
            return this;
        }

        public Builder dataHoraInicio(LocalDateTime dataHoraInicio) {
            this.dataHoraInicio = dataHoraInicio;
            return this;
        }

        public Builder dataHoraFim(LocalDateTime dataHoraFim) {
            this.dataHoraFim = dataHoraFim;
            return this;
        }

        public Builder localEvento(String localEvento) {
            this.localEvento = localEvento;
            return this;
        }

        public Builder capacidade(Integer capacidade) {
            this.capacidade = capacidade;
            return this;
        }

        public Builder organizador(String organizador) {
            this.organizador = organizador;
            return this;
        }

        public Builder tipo(TipoVento tipo) {
            this.tipo = tipo;
            return this;
        }

        public Evento build() {
            return new Evento(id, nome, descricao, identificador, dataHoraInicio, dataHoraFim, localEvento, capacidade, organizador, tipo);
        }

    }
    public static Builder builder(){
        return new Builder();
    }


}
