package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboMove {

    private final MoveType moveType;

    public RoboMove(MoveType moveType) {
        this.moveType = moveType;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
