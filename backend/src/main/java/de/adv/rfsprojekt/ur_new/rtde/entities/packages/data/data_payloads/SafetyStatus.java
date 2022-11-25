package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class SafetyStatus extends DataPayload {

    private Map<SafetyStatusType, Boolean> safetyStatusMap;

    public SafetyStatus(Map<SafetyStatusType, Boolean> safetyStatusMap) {
        super(DataType.SAFETY_STATUS);
        this.safetyStatusMap = safetyStatusMap;
    }

    public static SafetyStatus unpack(int payload) {
        Map<SafetyStatusType, Boolean> safetyStatuse = new HashMap<>();
        BigInteger statusBits = BigInteger.valueOf(payload);
        SafetyStatusType[] types = SafetyStatusType.values();
        for (int i = 0; i < types.length; i++) {
            safetyStatuse.put(types[i], statusBits.testBit(i));
        }
        return new SafetyStatus(safetyStatuse);
    }


    @Override
    public Map<SafetyStatusType, Boolean> getPayload() {
        return safetyStatusMap;
    }
}
