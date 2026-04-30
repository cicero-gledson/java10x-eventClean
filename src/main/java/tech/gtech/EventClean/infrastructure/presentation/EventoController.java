package tech.gtech.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.*;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.usecases.BuscarEventoCase;
import tech.gtech.EventClean.core.usecases.BuscarTodosEventoCase;
import tech.gtech.EventClean.core.usecases.CriarEventoCase;
import tech.gtech.EventClean.infrastructure.dtos.EventoDTO;
import tech.gtech.EventClean.infrastructure.mapper.EventoMapper;
import tech.gtech.EventClean.infrastructure.persistence.EventoEntity;
import tech.gtech.EventClean.infrastructure.persistence.EventoRepository;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final BuscarTodosEventoCase buscarTodosEventoCase;

    public EventoController(CriarEventoCase criarEventoCase, BuscarEventoCase buscarEventoCase, BuscarTodosEventoCase buscarTodosEventoCase) {
        this.criarEventoCase = criarEventoCase;
        this.buscarEventoCase = buscarEventoCase;
        this.buscarTodosEventoCase = buscarTodosEventoCase;
    }

    @PostMapping
    public EventoDTO criarEvento(@RequestBody EventoDTO evento) {
        Evento novoEvento =  criarEventoCase.execute(EventoMapper.toEntity(evento));
        return EventoMapper.toDto(novoEvento);
    }
    @GetMapping("/{id}")
    public EventoDTO buscarEvento(@PathVariable Long id) {
        Evento evento = buscarEventoCase.execute(id);
        return EventoMapper.toDto(evento);
    }

    @GetMapping
    public List<EventoDTO> buscarTodosEventos(){
        return buscarTodosEventoCase.execute().stream()
                .map(EventoMapper::toDto)
                .toList();
    }

}
