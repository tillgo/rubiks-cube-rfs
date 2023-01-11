package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

public enum SafetyStatusType {
    NORMAL_MODE(0), REDUCED_MODE(1), PROTECTIVE_STOPPED(2),
    RECOVERY_MODE(3), SAFEGUARD_STOPPED(4), SYSTEM_EMERGENCY_STOPPED(5),
    ROBOT_EMERGENCY_STOPPED(6), EMERGENCY_STOPPED(7), VIOLATION(8), FAULT(9),
    SAFETY_STOPPED(10);

    private final int bitIndex;

    SafetyStatusType(int bitIndex) {
        this.bitIndex = bitIndex;
    }

    public int getBit() {
        return bitIndex;
    }
}
