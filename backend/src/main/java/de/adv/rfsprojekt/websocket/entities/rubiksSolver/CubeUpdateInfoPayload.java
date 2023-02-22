package de.adv.rfsprojekt.websocket.entities.rubiksSolver;

import de.adv.rfsprojekt.rubiks_solver.models.CubeUpdate;
import de.adv.rfsprojekt.websocket.entities.InfoMessageType;
import de.adv.rfsprojekt.websocket.entities.InfoPayload;

public class CubeUpdateInfoPayload extends InfoPayload<CubeUpdate> {
    public CubeUpdateInfoPayload(CubeUpdate data) {
        super(InfoMessageType.CUBE_UPDATE, data);
    }
}
