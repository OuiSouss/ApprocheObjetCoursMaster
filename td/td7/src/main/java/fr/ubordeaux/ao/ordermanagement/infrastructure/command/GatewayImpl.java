package fr.ubordeaux.ao.ordermanagement.infrastructure.command;

import fr.ubordeaux.ao.ordermanagement.application.command.Command;
import fr.ubordeaux.ao.ordermanagement.application.command.Gateway;
import fr.ubordeaux.ao.ordermanagement.application.command.Handler;
import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;

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
            throw new OrderException("Handler is null");
        }
        handlerSet.add(handler);
    }
}
