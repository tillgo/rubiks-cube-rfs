package de.adv.rfsprojekt.websocket.entities;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatusType;

import java.util.Map;

public class RoboStatusInfoMessage extends WebsocketMessage<RoboStatusInfoPayload> {

    public RoboStatusInfoMessage(RoboStatusInfoPayload payload){
        super(MessageType.INFO, payload);
    }
}
