package de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur.rtde.entities.packages.data.VariableType;

public abstract class DataPayload {
    private VariableType variableType;

    public DataPayload(VariableType variableType) {
        this.variableType = variableType;
    }

    public VariableType getDataType() {
        return variableType;
    }

    public abstract Object getPayload();

}
