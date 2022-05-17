package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.*;

public class AgregarDirectrizDeMentoria extends Command {
    private final MentoriaId mentoriaId;
    private final Directiz directiz;
    private final CursoId cursoId;

    public AgregarDirectrizDeMentoria(CursoId cursoId, MentoriaId mentoriaId, Directiz directiz) {
        this.mentoriaId = mentoriaId;
        this.directiz = directiz;
        this.cursoId = cursoId;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public Directiz getDirectiz() {
        return directiz;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
