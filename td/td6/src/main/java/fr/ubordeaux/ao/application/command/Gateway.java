package fr.ubordeaux.ao.application.command;

public interface Gateway {
    public void add(Command c);
    public Command pop();

}
