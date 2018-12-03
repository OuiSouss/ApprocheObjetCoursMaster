package fr.ubordeaux.ao.ordermanagement.application.command;

public interface Gateway {
    void pushCommand(Command command);
    void addCommandHandler(Handler handler);
}
