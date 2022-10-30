package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboToolMove extends RoboMove {

    private final RoboToolMoveDirection moveDirection;

    public RoboToolMove(MoveType moveType, RoboToolMoveDirection moveDirection) {
        super(moveType);
        this.moveDirection = moveDirection;
    }

    public RoboToolMoveDirection getMoveDirection() {
        return moveDirection;
    }
}

