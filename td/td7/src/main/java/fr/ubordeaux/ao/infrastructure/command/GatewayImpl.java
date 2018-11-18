package fr.ubordeaux.ao.infrastructure.command;

import fr.ubordeaux.ao.application.command.Command;
import fr.ubordeaux.ao.application.command.Gateway;
import fr.ubordeaux.ao.application.command.Handler;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GatewayImpl implements Gateway {
    private Set<Handler> handlerSet;
    private Random random;

    public GatewayImpl() {
        handlerSet = new HashSet<Handler>();
        random = new Random();
    }

    @Override
    public void pushCommand(Command command) {
        int index = random.nextInt(handlerSet.size());
        for (Handler handler : handlerSet) {
            handler.handle(command);
        }
    }

    @Override
    public void addCommandHandler(Handler handler) {
        if (handler == null) {
            throw new ReferenceManagementException("Handler is null");
        }
        handlerSet.add(handler);
    }
}
