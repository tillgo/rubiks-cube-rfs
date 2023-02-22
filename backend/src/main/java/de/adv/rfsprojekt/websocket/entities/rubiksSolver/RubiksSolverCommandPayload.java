package de.adv.rfsprojekt.websocket.entities.rubiksSolver;

import de.adv.rfsprojekt.websocket.entities.BasePayload;

public class RubiksSolverCommandPayload implements BasePayload {

    private final RubiksSolverCommandType rubiksSolverCommandType;

    public RubiksSolverCommandPayload(RubiksSolverCommandType rubiksSolverCommandType) {
        this.rubiksSolverCommandType = rubiksSolverCommandType;
    }

    public RubiksSolverCommandType getCommandType() {
        return rubiksSolverCommandType;
    }
}
