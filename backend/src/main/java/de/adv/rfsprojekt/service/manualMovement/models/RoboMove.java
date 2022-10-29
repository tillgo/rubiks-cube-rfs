package de.adv.rfsprojekt.service.manualMovement.models;

public sealed interface RoboMove permits RoboArmMove, RoboToolMove, GripperMove {

    MoveType getMoveType();

    void setMoveType(MoveType moveType);

}
