package tech.gtech.EventClean.infrastructure.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.gtech.EventClean.core.exceptions.DuplicateIdentificadorEventoException;
import tech.gtech.EventClean.core.exceptions.EventoNaoEncontradoException;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    
    @ExceptionHandler(DuplicateIdentificadorEventoException.class)
    public ResponseEntity<ErroDTO> handleDataIntegrityViolationException
            (DuplicateIdentificadorEventoException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;
        ErroDTO erroDTO = getDto(status, ex.getMessage(), request);

        return ResponseEntity.status(status).body(erroDTO);
    }
    
    @ExceptionHandler(EventoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handleEventoNaoEncontradoException
            (EventoNaoEncontradoException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroDTO erroDTO = getDto(status, ex.getMessage(), request);

        return ResponseEntity.status(status).body(erroDTO);
    }

    private static ErroDTO getDto(HttpStatus status, String exMensagem, HttpServletRequest request) {

        return new ErroDTO(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                exMensagem,
                request.getRequestURI());
    }

}
