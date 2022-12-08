package de.adv.rfsprojekt.websocket.entities;

public class ErrorMessage extends WebsocketMessage {

    private final ErrorPayload payload;

    public ErrorMessage(ErrorPayload payload) {
        this.payload = payload;
    }

    @Override
    public MessageType getType() {
        return MessageType.ERROR;
    }

    public ErrorPayload getPayload() {
        return payload;
    }
}
