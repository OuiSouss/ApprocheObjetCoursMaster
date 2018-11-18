package fr.ubordeaux.ao.application.command;

import java.util.UUID;

public interface CommandMonitor {
    void commandIsExecuted(UUID id);
}
