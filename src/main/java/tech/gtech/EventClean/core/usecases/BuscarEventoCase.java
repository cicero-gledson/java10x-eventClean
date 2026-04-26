package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;

public interface BuscarEventoCase {
    public Evento execute(Long id);
}
