package tech.gtech.EventClean.infrastructure.presentation;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.gtech.EventClean.core.entities.Evento;
import tech.gtech.EventClean.core.usecases.BuscarEventoCase;
import tech.gtech.EventClean.core.usecases.BuscarIdentificadorEventoCase;
import tech.gtech.EventClean.core.usecases.BuscarTodosEventoCase;
import tech.gtech.EventClean.core.usecases.CriarEventoCase;
import tech.gtech.EventClean.infrastructure.dtos.EventoDTO;
import tech.gtech.EventClean.infrastructure.mapper.EventoMapper;
import tech.gtech.EventClean.infrastructure.persistence.EventoEntity;
import tech.gtech.EventClean.infrastructure.persistence.EventoRepository;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final BuscarTodosEventoCase buscarTodosEventoCase;
    private final BuscarIdentificadorEventoCase  buscarIdentificadorEventoCase;

    public EventoController(CriarEventoCase criarEventoCase, BuscarEventoCase buscarEventoCase, BuscarTodosEventoCase buscarTodosEventoCase, BuscarIdentificadorEventoCase buscarIdentificadorEventoCase) {
        this.criarEventoCase = criarEventoCase;
        this.buscarEventoCase = buscarEventoCase;
        this.buscarTodosEventoCase = buscarTodosEventoCase;
        this.buscarIdentificadorEventoCase = buscarIdentificadorEventoCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDTO evento) {

        Evento novoEvento =  criarEventoCase.execute(EventoMapper.toEntity(evento));
        EventoDTO novoEventoDto = EventoMapper.toDto(novoEvento);
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "Evento criado com sucesso");
        response.put("Evento", novoEventoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoEvento.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
    @GetMapping
    public List<EventoDTO> buscarTodosEventos(){
        return buscarTodosEventoCase.execute().stream()
                .map(EventoMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public EventoDTO buscarEvento(@PathVariable Long id) {
        Evento evento = buscarEventoCase.execute(id);
        return EventoMapper.toDto(evento);
    }

    @GetMapping("/busca")
    public EventoDTO buscarEventoPorIdentificador(@PathParam("identificador") String identificador) {
        Evento evento = buscarIdentificadorEventoCase.execute(identificador);
        return EventoMapper.toDto(evento);
    }

}
