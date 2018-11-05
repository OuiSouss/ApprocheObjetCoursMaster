package fr.ubordeaux.ao.infrastructure.command;

import fr.ubordeaux.ao.application.command.Command;
import fr.ubordeaux.ao.application.command.Gateway;
import fr.ubordeaux.ao.application.command.Handler;

public class HandlerImpl implements Handler {
    private Gateway gateway;

    public HandlerImpl(Gateway gateway) {
        this.gateway = gateway;
    }

    public void handle(Command command) {
        while (gateway != null)
            command.execute();
    }
}
