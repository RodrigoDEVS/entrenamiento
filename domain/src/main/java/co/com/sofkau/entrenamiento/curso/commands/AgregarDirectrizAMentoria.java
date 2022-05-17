package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Fecha;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;
import co.com.sofkau.entrenamiento.curso.values.Nombre;

public class AgregarDirectrizAMentoria extends Command {
    private final MentoriaId mentoriaId;
    private final Nombre nombre;
    private final Fecha fecha;
    private final CursoId cursoId;

    public AgregarDirectrizAMentoria(CursoId cursoId, MentoriaId mentoriaId, Nombre nombre, Fecha fecha) {
        this.mentoriaId = mentoriaId;
        this.nombre = nombre;
        this.fecha = fecha;
        this.cursoId = cursoId;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
