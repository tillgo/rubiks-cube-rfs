package de.adv.rfsprojekt.websocket.entities;

import de.adv.rfsprojekt.service.manualMovement.models.ManualMovementCommandType;

public class ManualMovementCommandPayload implements BasePayload {

    private final ManualMovementCommandType manualMovementCommandType;

    private final String command;

    public ManualMovementCommandPayload(ManualMovementCommandType manualMovementCommandType, String command) {
        this.manualMovementCommandType = manualMovementCommandType;
        this.command = command;
    }

    public ManualMovementCommandType getCommandType() {
        return manualMovementCommandType;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "ManualMovementCommandPayload{" +
                "commandType=" + manualMovementCommandType +
                ", command=" + command +
                '}';
    }
}
