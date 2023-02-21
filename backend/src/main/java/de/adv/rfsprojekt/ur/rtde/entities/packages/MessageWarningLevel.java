package de.adv.rfsprojekt.ur.rtde.entities.packages;

public enum MessageWarningLevel {
    EXCEPTION_MESSAGE(0),
    ERROR_MESSAGE(1),
    WARNING_MESSAGE(2),
    INFO_MESSAGE(3);
    private int value;

    MessageWarningLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MessageWarningLevel valueOfLabel(int label) {
        for (MessageWarningLevel e : values()) {
            if (e.getValue() == label) {
                return e;
            }
        }
        return null;
    }
}
