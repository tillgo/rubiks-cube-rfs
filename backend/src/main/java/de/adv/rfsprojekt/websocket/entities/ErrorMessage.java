package de.adv.rfsprojekt.websocket.entities;

public class ErrorMessage extends WebsocketMessage<ErrorPayload> {

    public ErrorMessage(ErrorPayload payload) {
        super(MessageType.ERROR, payload);
    }

}
