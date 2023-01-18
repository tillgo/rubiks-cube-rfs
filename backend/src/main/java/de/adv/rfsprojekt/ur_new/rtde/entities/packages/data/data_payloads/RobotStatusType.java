package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

public enum RobotStatusType {
    POWER_ON(0), PROGRAMM_RUNNING(1), TEACH_BUTTON_PRESSED(2), POWER_BUTTON_PRESSED(3);

    private final int bitIndex;

    RobotStatusType(int bitIndex) {
        this.bitIndex = bitIndex;
    }

    public int getBitIndex() {
        return bitIndex;
    }
}
