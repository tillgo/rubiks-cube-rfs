package de.adv.rfsprojekt.websocket.entities;

public abstract class WebsocketMessage {

    public abstract MessageType getType();

    @Override
    public String toString() {
        return "WebsocketMessage{" +
                "type=" + this.getType() +
                '}';
    }
}
