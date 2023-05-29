package de.adv.rfsprojekt.websocket.entities.manualMovement;

import de.adv.rfsprojekt.websocket.entities.MessageType;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;

public class ManualMovementCommand extends WebsocketMessage<ManualMovementCommandPayload> {

    public ManualMovementCommand(ManualMovementCommandPayload payload) {
        super(MessageType.COMMAND, payload);
    }

}
