package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

public enum DataType {
    ACTUAL_TCP_POSE("actual_TCP_pose");

    private String name;

    DataType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
