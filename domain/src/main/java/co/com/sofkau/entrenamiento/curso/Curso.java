package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadaDeMentoria;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;
import co.com.sofkau.entrenamiento.curso.values.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso extends AggregateEvent<CursoId> {
    protected Nombre nombre;
    protected Descripcion descripcion;
    protected Coach coach;
    protected Set<Contenido> contenidos;
    protected Map<MentoriaId, Mentoria> mentorias;

    public Curso(CursoId cursoId, Nombre nombre, Descripcion descripcion) {
        super(cursoId);
        appendChange(new CursoCreado(nombre, descripcion)).apply();
        subscribe(new CursoEventChange(this));
    }

    private Curso(CursoId cursoId){
        super(cursoId);
        subscribe(new CursoEventChange(this));
    }


    public static Curso from(CursoId cursoId, List<DomainEvent> events){
        var curso = new Curso(cursoId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarMentoria( Nombre nombre, Fecha fecha){
        var mentoriaId = new MentoriaId();
        appendChange(new MentoriaCreada(mentoriaId, nombre, fecha)).apply();
    }

    public void agregarDirectrizDeMentoria(MentoriaId mentoriaId, Directiz directiz){
        appendChange(new DirectrizAgregadaDeMentoria(mentoriaId, directiz)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion(){
        return descripcion;
    }

    public Coach coach(){
        return coach;
    }
}
