package de.adv.rfsprojekt.service.manualMovement.models;

public class RoboComand {

    private final ManualMovementCommandType manualMovementCommandType;

    public RoboComand(ManualMovementCommandType manualMovementCommandType) {
        this.manualMovementCommandType = manualMovementCommandType;
    }

    public ManualMovementCommandType getCommandType() {
        return manualMovementCommandType;
    }
}
