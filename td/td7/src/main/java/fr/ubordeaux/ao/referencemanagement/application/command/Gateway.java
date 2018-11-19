package fr.ubordeaux.ao.referencemanagement.application.command;

public interface Gateway {
    void pushCommand(Command command);
    void addCommandHandler(Handler handler);
}
