package fr.ubordeaux.ao.referencemanagement.application.command;

import java.util.UUID;

public interface CommandMonitor {
    void commandIsExecuted(UUID id);
}
