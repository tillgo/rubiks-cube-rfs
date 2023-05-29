package de.adv.rfsprojekt.websocket.entities.rubiksSolver;

import de.adv.rfsprojekt.websocket.entities.BasePayload;

public class RubiksSolverCommandPayload implements BasePayload {

    private final RubiksSolverCommandType command;

    public RubiksSolverCommandPayload(RubiksSolverCommandType command) {
        this.command = command;
    }

    public RubiksSolverCommandType getCommand() {
        return command;
    }
}
