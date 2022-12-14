package de.adv.rfsprojekt.websocket.entities;

public abstract class WebsocketMessage<T extends BasePayload> {

    private final MessageType type;

    private final T payload;

    public WebsocketMessage(MessageType type, T payload) {
        this.type = type;
        this.payload = payload;
    }

    public MessageType getType(){
        return this.type;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "WebsocketMessage{" +
                "type=" + this.getType() +
                '}';
    }
}
