package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

import de.adv.rfsprojekt.ur_new.rtde.entities.exceptions.URRuntimeException;

public enum VariableType {
    UINT64("UINT64"),
    INT32("INT32"),
    DOUBLE("DOUBLE"),
    VECTOR3D("VECTOR3D"),
    VECTOR6D("VECTOR6D"),
    VECTOR6INT32("VECTOR6INT32"),
    VECTOR6UINT32("VECTOR6UINT32");

    private String type;

    VariableType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static VariableType valueOfLabel(String label) {
        for (VariableType e : values()) {
            if (e.getType().equals(label)) {
                return e;
            }
        }
        throw new URRuntimeException("VariableType doesnt exist");
    }
}
