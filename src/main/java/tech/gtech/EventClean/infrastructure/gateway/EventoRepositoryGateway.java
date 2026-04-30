package tech.gtech.EventClean.infrastructure.gateway;

import org.springframework.stereotype.Component;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.gateway.EventoGateway;
import tech.gtech.EventClean.infrastructure.mapper.EventoEntityMapper;
import tech.gtech.EventClean.infrastructure.mapper.EventoMapper;
import tech.gtech.EventClean.infrastructure.persistence.EventoEntity;
import tech.gtech.EventClean.infrastructure.persistence.EventoRepository;

import java.util.List;

@Component
public class EventoRepositoryGateway implements EventoGateway {


    private final EventoRepository eventoRepository;
    
    public EventoRepositoryGateway(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity novoEventoEntity = eventoRepository.save(EventoEntityMapper.toEventoEntity(evento));
        return EventoEntityMapper.toDomain(novoEventoEntity);
    }

    @Override
    public Evento buscarEvento(Long id) {
        EventoEntity eventoEntity = eventoRepository.findById(id).orElseThrow();
        return EventoEntityMapper.toDomain(eventoEntity);
    }

    @Override
    public List<Evento> buscarTodosEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoEntityMapper::toDomain)
                .toList();
    }
}
