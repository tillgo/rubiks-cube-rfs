package de.adv.rfsprojekt.service.manualMovement.models;

import de.adv.rfsprojekt.ur_new.entities.Pose;

/**
 * MoveDirections for RoboArmMoveDirection. Every
 * Direction contains a Pose-Object with the speed
 * it schould move in the corresponding direction
 */
public enum RoboArmMoveDirection {
    /* ToDo Toolspeed aus Env-Variablen nutzen  */
    Xminus(new Pose(0.2, 0, 0, 0, 0, 0)),
    Xplus(new Pose(-0.2, 0, 0, 0, 0, 0)),
    Yplus(new Pose(0, 0.2, 0, 0, 0, 0)),
    Yminus(new Pose(0, -0.2, 0, 0, 0, 0)),
    Zplus(new Pose(0, 0, 0.2, 0, 0, 0)),
    Zminus(new Pose(0, 0, -0.2, 0, 0, 0));

    private final Pose pose;

    RoboArmMoveDirection(Pose pose) {
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }
}

