package de.adv.rfsprojekt.websocket.entities;

import de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads.SafetyStatusType;

import java.util.Map;

public class RoboStatusInfoPayload extends InfoPayload<Map<SafetyStatusType, Boolean>> {

    public RoboStatusInfoPayload(Map<SafetyStatusType, Boolean> safetyStatus) {
        super(InfoMessageType.ROBO_STATUS, safetyStatus);
    }

}
