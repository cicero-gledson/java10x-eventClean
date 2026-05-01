package tech.gtech.EventClean.infrastructure.gateway;

import org.springframework.stereotype.Component;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.exceptions.EventoNaoEncontradoException;
import tech.gtech.EventClean.core.gateway.EventoGateway;
import tech.gtech.EventClean.infrastructure.mapper.EventoEntityMapper;
import tech.gtech.EventClean.infrastructure.mapper.EventoMapper;
import tech.gtech.EventClean.infrastructure.persistence.EventoEntity;
import tech.gtech.EventClean.infrastructure.persistence.EventoRepository;

import java.util.List;
import java.util.Optional;

@Component
public class EventoRepositoryGateway implements EventoGateway {


    private final EventoRepository eventoRepository;
    
    public EventoRepositoryGateway(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity eventoEntity = EventoEntityMapper.toEventoEntity(evento);

        while (identificadorEventoExiste(eventoEntity.gerarIdentificador()));

        eventoEntity = eventoRepository.save(eventoEntity);

        return EventoEntityMapper.toDomain(eventoEntity);
    }

    @Override
    public Optional<Evento> buscarEvento(Long id) {
        return eventoRepository.findById(id).map(EventoEntityMapper::toDomain);
    }

    @Override
    public List<Evento> buscarTodosEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Boolean identificadorEventoExiste(String identificador) {
        return eventoRepository.existsByIdentificador(identificador);
    }

    @Override
    public Optional<Evento> buscarIdentificadorEvento(String identificador) {
        return eventoRepository.findByIdentificador(identificador)
                .map(EventoEntityMapper::toDomain);

    }
}
