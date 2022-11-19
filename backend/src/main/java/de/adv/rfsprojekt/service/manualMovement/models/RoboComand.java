package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboComand {

    private final CommandType commandType;

    public RoboComand(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }
}
