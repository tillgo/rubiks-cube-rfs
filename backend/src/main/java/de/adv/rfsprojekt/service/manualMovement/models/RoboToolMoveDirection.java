package de.adv.rfsprojekt.service.manualMovement.models;

import de.adv.rfsprojekt.ur_new.entities.Pose;

public enum RoboToolMoveDirection {
    X_MINUS(new Pose(0, 0, 0, -0.2, 0, 0)),
    X_PLUS(new Pose(0, 0, 0, 0.2, 0, 0)),
    Y_PLUS(new Pose(0, 0, 0, 0, 0.2, 0)),
    Y_MINUS(new Pose(0, 0, 0, 0, -0.2, 0)),
    Z_PLUS(new Pose(0, 0, 0, 0, 0, 0.2)),
    Z_MINUS(new Pose(0, 0, 0, 0, 0, -0.2));

    private final Pose pose;

    RoboToolMoveDirection(Pose pose) {
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }
}
