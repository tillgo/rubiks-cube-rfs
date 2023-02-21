package de.adv.rfsprojekt.service.manualMovement.models;

import static de.adv.rfsprojekt.system.Config.*;
import de.adv.rfsprojekt.ur.entities.Pose;

public enum RoboToolCommand {
    X_MINUS(new Pose(0, 0, 0, -getMoveSpeedTool(), 0, 0)),
    X_PLUS(new Pose(0, 0, 0, getMoveSpeedTool(), 0, 0)),
    Y_PLUS(new Pose(0, 0, 0, 0, getMoveSpeedTool(), 0)),
    Y_MINUS(new Pose(0, 0, 0, 0, -getMoveSpeedTool(), 0)),
    Z_PLUS(new Pose(0, 0, 0, 0, 0, getMoveSpeedTool())),
    Z_MINUS(new Pose(0, 0, 0, 0, 0, -getMoveSpeedTool()));

    private final Pose pose;

    RoboToolCommand(Pose pose) {
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }
}
