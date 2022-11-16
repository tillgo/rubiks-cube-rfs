package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboToolCommand extends RoboComand {

    private final RoboToolCommandType command;

    public RoboToolCommand(CommandType commandType, RoboToolCommandType command) {
        super(commandType);
        this.command = command;
    }

    public RoboToolCommandType getCommand() {
        return command;
    }
}

