package fr.ubordeaux.ao.infrastructure.command;

import java.util.List;
import java.util.ArrayList;

import fr.ubordeaux.ao.application.command.Command;
import fr.ubordeaux.ao.application.command.Gateway;

public class GatewayImpl implements Gateway {
    private List<Command> commandList;

    public GatewayImpl() {
        commandList = new ArrayList<Command>();
    }

    public void add(Command c) {
        commandList.add(c);
    }

    public Command pop() {
        return commandList.remove(commandList.size() - 1);
    }
}
