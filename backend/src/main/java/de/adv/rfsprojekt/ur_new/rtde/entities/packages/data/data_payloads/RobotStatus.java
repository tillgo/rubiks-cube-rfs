package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class RobotStatus extends DataPayload {


    private Map<RobotStatusType, Boolean> robotStatusMap;

    public RobotStatus(Map<RobotStatusType, Boolean> robotStatusMap) {
        super(DataType.ROBOT_STATUS);
        this.robotStatusMap = robotStatusMap;
    }


    public static RobotStatus unpack(int payload) {
        Map<RobotStatusType, Boolean> robotStatuse = new HashMap<>();
        BigInteger statusBits = BigInteger.valueOf(payload);
        RobotStatusType[] types = RobotStatusType.values();
        for (int i = 0; i < types.length; i++) {
            robotStatuse.put(types[i], statusBits.testBit(i));
        }

        return new RobotStatus(robotStatuse);

    }

    @Override
    public Map<RobotStatusType, Boolean> getPayload() {
        return robotStatusMap;
    }

}
