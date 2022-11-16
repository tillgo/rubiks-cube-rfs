package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboToolMove extends RoboMove {

    private final RoboToolCommandType command;

    public RoboToolMove(MoveType moveType, RoboToolCommandType command) {
        super(moveType);
        this.command = command;
    }

    public RoboToolCommandType getCommand() {
        return command;
    }
}

