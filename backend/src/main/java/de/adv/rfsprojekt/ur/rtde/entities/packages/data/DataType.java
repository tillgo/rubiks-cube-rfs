package de.adv.rfsprojekt.ur.rtde.entities.packages.data;

import de.adv.rfsprojekt.ur.rtde.entities.exceptions.URRuntimeException;

public enum DataType {
    BOOL("BOOL"),
    UNINT8("UINT8"),
    UINT32("UINT32"),
    UINT64("UINT64"),
    INT32("INT32"),
    DOUBLE("DOUBLE"),
    VECTOR3D("VECTOR3D"),
    VECTOR6D("VECTOR6D"),
    VECTOR6INT32("VECTOR6INT32"),
    VECTOR6UINT32("VECTOR6UINT32");

    private String type;

    DataType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DataType valueOfLabel(String label) {
        for (DataType e : values()) {
            if (e.getType().equals(label)) {
                return e;
            }
        }
        throw new URRuntimeException("VariableType doesnt exist");
    }
}
