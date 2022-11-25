package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboSetupCommand extends RoboComand {

    private RoboSetupCommandType command;

    public RoboSetupCommand(CommandType commandType, RoboSetupCommandType command) {
        super(commandType);
        this.command = command;
    }

    public RoboSetupCommandType getCommand() {
        return command;
    }
}
