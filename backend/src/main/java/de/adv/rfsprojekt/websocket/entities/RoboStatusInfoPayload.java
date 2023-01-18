package de.adv.rfsprojekt.websocket.entities;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatusType;

import java.util.Map;

public class RoboStatusInfoPayload implements BasePayload {

    private final InfoMessageType infoType;

    private final Map<SafetyStatusType, Boolean> safetyStatus;

    public RoboStatusInfoPayload(Map<SafetyStatusType, Boolean> safetyStatus) {
        this.infoType = InfoMessageType.ROBO_STATUS;
        this.safetyStatus = safetyStatus;
    }

    public InfoMessageType getInfoType() {
        return infoType;
    }

    public Map<SafetyStatusType, Boolean> getSafetyStatus() {
        return safetyStatus;
    }
}
