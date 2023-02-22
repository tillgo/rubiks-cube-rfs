package de.adv.rfsprojekt.websocket.entities.rubiksSolver;

import de.adv.rfsprojekt.rubiks_solver.models.ScanCompleteInfo;
import de.adv.rfsprojekt.websocket.entities.InfoMessageType;
import de.adv.rfsprojekt.websocket.entities.InfoPayload;

public class ScanCompleteInfoPayload extends InfoPayload<ScanCompleteInfo> {

    public ScanCompleteInfoPayload(ScanCompleteInfo scanCompleteInfo) {
        super(InfoMessageType.SCAN_COMPLETE, scanCompleteInfo);
    }

}
