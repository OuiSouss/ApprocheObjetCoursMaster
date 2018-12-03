package fr.ubordeaux.ao.ordermanagement.application.command;

import java.util.UUID;

public abstract class Command {
    private UUID id;

    public Command() {
        id = UUID.randomUUID();
    }

    public abstract void execute();
}
