package fr.ubordeaux.ao.infrastructure.command;

import fr.ubordeaux.ao.application.command.Command;
import fr.ubordeaux.ao.application.command.Handler;

public class HandlerImpl implements Handler {

    @Override
    public void handle(Command command) {
        command.execute();
    }
}
