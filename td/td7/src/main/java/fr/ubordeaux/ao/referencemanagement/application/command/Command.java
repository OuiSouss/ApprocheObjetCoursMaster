package fr.ubordeaux.ao.referencemanagement.application.command;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;

public abstract class Command {
    private List<CommandMonitor> monitorList;
    private UUID id;

    public Command() {
        id = UUID.randomUUID();
        monitorList = new ArrayList<CommandMonitor>();
    }

    public void execute() {
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
            monitor.commandIsExecuted(id);
        }
    }

    protected abstract void executeCommand();
}
