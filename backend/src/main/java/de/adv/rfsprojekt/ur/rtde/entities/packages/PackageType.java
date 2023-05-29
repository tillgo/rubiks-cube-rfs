package de.adv.rfsprojekt.ur.rtde.entities.packages;


public enum PackageType {
    RTDE_REQUEST_PROTOCOL_VERSION((byte) 86),
    RTDE_GET_URCONTROL_VERSION((byte) 118),
    RTDE_TEXT_MESSAGE((byte) 77),
    RTDE_DATA_PACKAGE((byte) 85),
    RTDE_CONTROL_PACKAGE_SETUP_OUTPUTS((byte) 79),
    RTDE_CONTROL_PACKAGE_SETUP_INPUTS((byte) 73),
    RTDE_CONTROL_PACKAGE_START((byte) 83),
    RTDE_CONTROL_PACKAGE_PAUSE((byte) 80);
    private byte value;

    PackageType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public static PackageType valueOfLabel(byte label) {
        for (PackageType e : values()) {
            if (e.getValue() == label) {
                return e;
            }
        }
        return null;
    }
}