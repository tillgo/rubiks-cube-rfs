package de.adv.rfsprojekt.service.manualMovement.models;

import de.adv.rfsprojekt.ur_new.entities.Pose;

/**
 * MoveDirections for RoboArmMoveDirection. Every
 * Direction contains a Pose-Object with the speed
 * it schould move in the corresponding direction
 */
public enum RoboArmMoveDirection {
    /* ToDo Toolspeed aus Env-Variablen nutzen  */
    LEFT(new Pose(0.2, 0, 0, 0, 0, 0)),
    RIGHT(new Pose(-0.2, 0, 0, 0, 0, 0)),
    FRONT(new Pose(0, 0.2, 0, 0, 0, 0)),
    BACK(new Pose(0, -0.2, 0, 0, 0, 0));

    private final Pose pose;

    RoboArmMoveDirection(Pose pose) {
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }
}

