package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

public abstract class DataPayload {
    private DataType dataType;

    public DataPayload(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public abstract Object getPayload();

}
