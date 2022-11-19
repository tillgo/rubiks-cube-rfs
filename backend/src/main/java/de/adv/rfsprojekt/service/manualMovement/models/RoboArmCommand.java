package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboArmCommand extends RoboComand {

    private final RoboArmCommandType command;

    public RoboArmCommand(CommandType commandType, RoboArmCommandType command) {
        super(commandType);
        this.command = command;
    }

    public RoboArmCommandType getCommand() {
        return command;
    }
}



