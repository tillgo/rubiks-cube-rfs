package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboArmMove extends RoboMove {

    private final RoboArmCommandType command;

    public RoboArmMove(MoveType moveType, RoboArmCommandType command) {
        super(moveType);
        this.command = command;
    }

    public RoboArmCommandType getCommand() {
        return command;
    }
}



