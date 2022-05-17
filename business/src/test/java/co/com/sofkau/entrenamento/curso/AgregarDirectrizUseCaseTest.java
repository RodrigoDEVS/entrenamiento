package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectrizDeMentoria;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadaDeMentoria;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;
import co.com.sofkau.entrenamiento.curso.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarDirectrizUseCaseTest {

    @InjectMocks
    private AgregarDirectrizUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDirectrizDeMentoriaHappyPass(){
        //arrange
        CursoId cursoId = CursoId.of("xxx");
        MentoriaId mentoriaId = MentoriaId.of("yyy");
        Directiz directiz = new Directiz("Nueva Directriz");
        var command = new AgregarDirectrizDeMentoria(cursoId, mentoriaId, directiz);

        when(repository.getEventsBy("xxx")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCursoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DirectrizAgregadaDeMentoria)events.get(0);
        Assertions.assertEquals("Nueva Directriz", event.getDirectiz().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("DDD");
        Descripcion descripcion = new Descripcion("Curso complementario para el training");
        var event = new CursoCreado(
                nombre,
                descripcion
        );
        event.setAggregateRootId("rrrr");

        MentoriaId mentoriaId = MentoriaId.of("ddddd");
        Nombre nombreM = new Nombre("Aprendiendo de casos de usos");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var event2 = new MentoriaCreada(mentoriaId, nombreM, fecha);

        return List.of(event, event2);
    }
}