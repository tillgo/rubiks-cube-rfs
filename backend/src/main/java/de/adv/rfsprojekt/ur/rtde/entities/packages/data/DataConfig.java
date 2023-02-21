package de.adv.rfsprojekt.ur.rtde.entities.packages.data;

import java.util.List;

public class DataConfig {

    private List<VariableType> variableTypes;
    private List<DataType> dataTypes;

    public DataConfig(List<VariableType> variableTypes, List<DataType> dataTypes) {
        this.variableTypes = variableTypes;
        this.dataTypes = dataTypes;
    }

    public List<VariableType> getVariableTypes() {
        return variableTypes;
    }

    public List<DataType> getDataTypes() {
        return dataTypes;
    }
}
