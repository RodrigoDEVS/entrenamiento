package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Mentoria;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectrizAMentoria;

public class AgregarDirectrizUseCase extends UseCase<RequestCommand<AgregarDirectrizAMentoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDirectrizAMentoria> agregarDirectrizAMentoriaRequestCommand) {
        var command = agregarDirectrizAMentoriaRequestCommand.getCommand();

        var mentoria = new Mentoria(command.getMentoriaId(), command.getNombre(), command.getFecha(), command.agre);
    }
}
