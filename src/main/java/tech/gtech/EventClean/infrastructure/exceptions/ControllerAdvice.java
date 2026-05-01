package tech.gtech.EventClean.infrastructure.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(DataIntegrityViolationException.class)

    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("Mensagem", "Erro na requisição");
        if (ex.getMessage().contains("eventos_identificador_key")) {
           response.put("Detalhes", "O identificador do evento deve ser único. O valor fornecido já existe.");
           return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
