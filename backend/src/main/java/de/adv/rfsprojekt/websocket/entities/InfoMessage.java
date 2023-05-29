package de.adv.rfsprojekt.websocket.entities;

public class InfoMessage<T extends InfoPayload<?>> extends WebsocketMessage<T> {

    public InfoMessage(T payload) {
        super(MessageType.INFO, payload);
    }
}
