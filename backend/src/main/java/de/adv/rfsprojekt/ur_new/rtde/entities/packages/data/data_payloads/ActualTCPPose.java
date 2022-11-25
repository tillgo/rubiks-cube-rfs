package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

public class ActualTCPPose extends DataPayload {

    private Pose pose;

    public ActualTCPPose(Object payload) {
        super(DataType.ACTUAL_TCP_POSE);
    }

    @Override
    public Pose getPayload() {
        return pose;
    }


}
