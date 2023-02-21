package de.adv.rfsprojekt.websocket.entities;

public class RoboStatusInfoMessage extends WebsocketMessage<RoboStatusInfoPayload> {

    public RoboStatusInfoMessage(RoboStatusInfoPayload payload){
        super(MessageType.INFO, payload);
    }
}
