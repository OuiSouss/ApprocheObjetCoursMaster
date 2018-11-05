package fr.ubordeaux.ao.application.command;

import java.util.List;
import java.util.ArrayList;

import fr.ubordeaux.ao.application.command.CommandMonitor;

public abstract class Command {
    private List<CommandMonitor> monitorList;

    public abstract void execute();
    public abstract void addMonitor(CommandMonitor monitor);
    public abstract void notifyMonitor();
}
