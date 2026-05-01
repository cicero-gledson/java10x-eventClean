package tech.gtech.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.gtech.EventClean.core.gateway.EventoGateway;
import tech.gtech.EventClean.core.usecases.*;
import tech.gtech.EventClean.infrastructure.gateway.EventoRepositoryGateway;
import tech.gtech.EventClean.infrastructure.persistence.EventoRepository;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarEventoCase criarEventoCase(EventoGateway eventoGateway) {
        return new CriarEventoCaseImpl(eventoGateway);
    }
    @Bean
    public BuscarEventoCase buscarEventoCase(EventoGateway  eventoGateway) {
        return new BuscarEventoCaseImpl(eventoGateway);
    }
    @Bean
    public BuscarTodosEventoCase buscarTodosEventoCase(EventoGateway  eventoGateway) {
        return new BuscarTodosEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarIdentificadorEventoCase buscarIdentificadorEventoCase(EventoGateway  eventoGateway) {
        return new BuscarIdentificadorEventoCaseImpl(eventoGateway);
    }

}
