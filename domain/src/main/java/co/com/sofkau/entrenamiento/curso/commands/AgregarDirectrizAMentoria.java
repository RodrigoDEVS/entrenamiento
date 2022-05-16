package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.Fecha;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;
import co.com.sofkau.entrenamiento.curso.values.Nombre;

public class AgregarDirectrizAMentoria extends Command {
    private final MentoriaId entityId;
    private final Nombre nombre;
    private final Fecha fecha;

    public AgregarDirectrizAMentoria(MentoriaId entityId, Nombre nombre, Fecha fecha) {
        this.entityId = entityId;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public MentoriaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
