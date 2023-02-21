package de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataType;

public class ActualTCPPose extends DataPayload {

    private Pose pose;

    public ActualTCPPose(Pose pose) {
        super(DataType.ACTUAL_TCP_POSE);
        this.pose = pose;
    }

    @Override
    public Pose getPayload() {
        return pose;
    }


}
