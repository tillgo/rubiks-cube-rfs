package de.adv.rfsprojekt.websocket.entities;

public class ManualMovementCommand extends WebsocketMessage {

    private final ManualMovementCommandPayload payload;

    public ManualMovementCommand(ManualMovementCommandPayload payload) {
        this.payload = payload;
    }

    @Override
    public MessageType getType() {
        return MessageType.COMMAND;
    }

    public ManualMovementCommandPayload getPayload() {
        return payload;
    }
}
