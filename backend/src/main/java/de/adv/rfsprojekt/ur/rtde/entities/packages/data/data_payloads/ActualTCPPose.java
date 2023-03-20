package de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.VariableType;

public class ActualTCPPose extends DataPayload {

    private Pose pose;

    public ActualTCPPose(Pose pose) {
        super(VariableType.ACTUAL_TCP_POSE);
        this.pose = pose;
    }

    @Override
    public Pose getPayload() {
        return pose;
    }


}
