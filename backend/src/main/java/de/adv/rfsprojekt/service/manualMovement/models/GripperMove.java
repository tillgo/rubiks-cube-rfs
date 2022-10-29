package de.adv.rfsprojekt.service.manualMovement.models;

public record GripperMove(MoveType moveType, GripperMoveDirection moveDirection) implements RoboMove {
    @Override
    public MoveType getMoveType() {
        return null;
    }

    @Override
    public void setMoveType(MoveType moveType) {

    }
}

