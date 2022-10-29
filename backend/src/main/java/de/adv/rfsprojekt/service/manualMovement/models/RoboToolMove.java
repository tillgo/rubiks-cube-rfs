package de.adv.rfsprojekt.service.manualMovement.models;

public record RoboToolMove(RoboToolMoveDirection moveDirection) implements RoboMove {
    @Override
    public MoveType getMoveType() {
        return null;
    }

    @Override
    public void setMoveType(MoveType moveType) {

    }
}

