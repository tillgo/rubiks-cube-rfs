package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

public enum DataType {
    ACTUAL_TCP_POSE("actual_TCP_pose"),
    SAFETY_STATUS("safety_status_bits"),

    ROBOT_STATUS("robot_status_bits");

    private String name;

    DataType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
