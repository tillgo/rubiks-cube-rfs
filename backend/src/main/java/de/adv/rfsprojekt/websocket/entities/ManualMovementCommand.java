package de.adv.rfsprojekt.websocket.entities;

public class ManualMovementCommand extends WebsocketMessage<ManualMovementCommandPayload> {

    public ManualMovementCommand(ManualMovementCommandPayload payload) {
        super(MessageType.COMMAND,payload);
    }

}
