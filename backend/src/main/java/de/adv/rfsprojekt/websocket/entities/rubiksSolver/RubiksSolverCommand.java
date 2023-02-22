package de.adv.rfsprojekt.websocket.entities.rubiksSolver;

import de.adv.rfsprojekt.websocket.entities.MessageType;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;

public class RubiksSolverCommand extends WebsocketMessage<RubiksSolverCommandPayload> {

    public RubiksSolverCommand(RubiksSolverCommandPayload payload) {
        super(MessageType.COMMAND, payload);
    }
}
