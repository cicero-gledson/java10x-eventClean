package tech.gtech.EventClean.infrastructure.exceptions;

import java.time.Instant;

public record ErroDTO(
        Instant timestamp, // Quando o erro ocorreu
        Integer status,    // Código HTTP (ex: 409, 404, 400)
        String error,      // Nome curto do erro (ex: "Conflict")
        String message,    // A mensagem clara para o usuário
        String path)       // O caminho da URL que causou o problema
{
}
