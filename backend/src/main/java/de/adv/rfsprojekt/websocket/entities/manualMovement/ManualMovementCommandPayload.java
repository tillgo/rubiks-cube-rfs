package de.adv.rfsprojekt.websocket.entities.manualMovement;

import de.adv.rfsprojekt.service.manualMovement.models.ManualMovementCommandType;
import de.adv.rfsprojekt.websocket.entities.BasePayload;

public class ManualMovementCommandPayload implements BasePayload {

    private final ManualMovementCommandType commandType;

    private final String command;

    public ManualMovementCommandPayload(ManualMovementCommandType commandType, String command) {
        this.commandType = commandType;
        this.command = command;
    }

    public ManualMovementCommandType getCommandType() {
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
