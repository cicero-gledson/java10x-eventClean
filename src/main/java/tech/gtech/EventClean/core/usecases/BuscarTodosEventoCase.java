package tech.gtech.EventClean.core.usecases;

import tech.gtech.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarTodosEventoCase {
    public List<Evento> execute();
}
