package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.application.command.Command;

public interface Handler {
    public void handle(Command command);
}
