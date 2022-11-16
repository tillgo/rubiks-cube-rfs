package de.adv.rfsprojekt.service.manualMovement.models;

public class GripperCommand extends RoboMove {

    private final GripperCommandType command;


    public GripperCommand(MoveType moveType, GripperCommandType commandType) {
        super(moveType);
        this.command = commandType;
    }

    public GripperCommandType getCommand() {
        return command;
    }
}

