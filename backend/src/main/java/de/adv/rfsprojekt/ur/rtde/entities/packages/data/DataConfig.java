package de.adv.rfsprojekt.ur.rtde.entities.packages.data;

import java.util.List;

public class DataConfig {

    private List<DataType> dataTypes;
    private List<VariableType> variableTypes;

    public DataConfig(List<DataType> dataTypes, List<VariableType> variableTypes) {
        this.dataTypes = dataTypes;
        this.variableTypes = variableTypes;
    }

    public List<DataType> getVariableTypes() {
        return dataTypes;
    }

    public List<VariableType> getDataTypes() {
        return variableTypes;
    }
}
