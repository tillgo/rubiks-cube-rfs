package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboArmMove extends RoboMove {

    private final RoboArmMoveDirection moveDirection;

    public RoboArmMove(MoveType moveType, RoboArmMoveDirection moveDirection) {
        super(moveType);
        this.moveDirection = moveDirection;
    }

    public RoboArmMoveDirection getMoveDirection() {
        return moveDirection;
    }
}



