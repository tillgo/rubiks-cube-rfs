package de.adv.rfsprojekt.websocket.entities;

public class RubiksSolverCommand extends WebsocketMessage<RubiksSolverCommandPayload> {

    public RubiksSolverCommand(RubiksSolverCommandPayload payload) {
        super(MessageType.COMMAND, payload);
    }
}
