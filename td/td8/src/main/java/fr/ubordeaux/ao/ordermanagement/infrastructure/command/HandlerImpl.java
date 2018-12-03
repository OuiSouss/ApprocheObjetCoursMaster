package fr.ubordeaux.ao.ordermanagement.infrastructure.command;

import fr.ubordeaux.ao.ordermanagement.application.command.Command;
import fr.ubordeaux.ao.ordermanagement.application.command.Handler;

public class HandlerImpl implements Handler {

    @Override
    public void handle(Command command) {
        command.execute();
    }
}
