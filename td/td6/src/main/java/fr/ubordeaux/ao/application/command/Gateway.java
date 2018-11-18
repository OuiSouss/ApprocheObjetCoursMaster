package fr.ubordeaux.ao.application.command;

public interface Gateway {
    void pushCommand(Command command);
    void addCommandHandler(Handler handler);
}
