package de.adv.rfsprojekt.service.manualMovement.models;

public class GripperMove extends RoboMove {

    private final GripperMoveDirection moveDirection;


    public GripperMove(MoveType moveType, GripperMoveDirection moveDirection) {
        super(moveType);
        this.moveDirection = moveDirection;
    }

    public GripperMoveDirection getMoveDirection() {
        return moveDirection;
    }
}

