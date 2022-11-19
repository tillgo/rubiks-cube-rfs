package de.adv.rfsprojekt.service.manualMovement.models;

public class GripperCommand extends RoboComand {

    private final GripperCommandType command;


    public GripperCommand(CommandType moveType, GripperCommandType commandType) {
        super(moveType);
        this.command = commandType;
    }

    public GripperCommandType getCommand() {
        return command;
    }
}

