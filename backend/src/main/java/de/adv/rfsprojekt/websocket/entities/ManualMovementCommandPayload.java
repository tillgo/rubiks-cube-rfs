package de.adv.rfsprojekt.websocket.entities;

import de.adv.rfsprojekt.service.manualMovement.models.CommandType;

public class ManualMovementCommandPayload implements BasePayload {

    private final CommandType commandType;

    private final String command;

    public ManualMovementCommandPayload(CommandType commandType, String command) {
        this.commandType = commandType;
        this.command = command;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "ManualMovementCommandPayload{" +
                "commandType=" + commandType +
                ", command=" + command +
                '}';
    }
}
