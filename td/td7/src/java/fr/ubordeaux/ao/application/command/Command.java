package fr.ubordeaux.ao.application.command;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import fr.ubordeaux.ao.application.command.CommandMonitor;

public abstract class Command {
    private List<CommandMonitor> monitorList;
    private UUID id;
    
    public Command() {
        id = UUID.randomUUID();
        monitorList = new ArrayList<CommandMonitor>();
    }

    public abstract void execute() {
        executeCommand();
        notifyMonitor();
    }
    
    public void addMonitor(CommandMonitor monitor) {
        if (monitor == null) {
            throw new ReferenceManagementException("Monitor is null");
        }
        monitorList.add(monitor);
    }
    
    private void notifyMonitor() {
        for (CommandMonitor monitor : monitorList) {
            monitor.commandIsExecuted();
        }
    }
    
    protected abstract void executeCommand();
}
