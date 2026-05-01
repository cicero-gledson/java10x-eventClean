package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;

public interface BuscarIdentificadorEventoCase {
    Evento execute(String identificador);
}
