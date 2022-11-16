package de.adv.rfsprojekt.service.manualMovement.models;

import static de.adv.rfsprojekt.system.Config.*;
import de.adv.rfsprojekt.ur_new.entities.Pose;

public enum RoboToolCommandType {
    X_MINUS(new Pose(0, 0, 0, -getMoveSpeedTool(), 0, 0)),
    X_PLUS(new Pose(0, 0, 0, getMoveSpeedTool(), 0, 0)),
    Y_PLUS(new Pose(0, 0, 0, 0, getMoveSpeedTool(), 0)),
    Y_MINUS(new Pose(0, 0, 0, 0, -getMoveSpeedTool(), 0)),
    Z_PLUS(new Pose(0, 0, 0, 0, 0, getMoveSpeedTool())),
    Z_MINUS(new Pose(0, 0, 0, 0, 0, -getMoveSpeedTool()));

    private final Pose pose;

    RoboToolCommandType(Pose pose) {
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }
}
