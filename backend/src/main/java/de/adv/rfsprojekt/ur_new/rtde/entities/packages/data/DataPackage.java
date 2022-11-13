package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPackage extends Package {

    private Map<DataType, Object> payload;

    public DataPackage(PackageType packageType, Map<DataType, Object> payload) {
        super(packageType);
        this.payload = payload;
    }

    public static Package unpack(ByteBuffer buffer, DataConfig config) {
        Map<DataType, Object> variables = new HashMap<>();

        List<VariableType> variableTypes = new ArrayList<>();
        List<DataType> dataTypes = new ArrayList<>();
        for (int i = 0; i <= variableTypes.size(); i++) {

            VariableType variableType = variableTypes.get(i);
            DataType dataType = dataTypes.get(i);

            switch (variableType) {
                case UINT64 -> {
                    //Not needed right now
                }
                case INT32 -> {
                    //Not needed right now
                }
                case DOUBLE -> {
                    //Not needed right now
                }
                case VECTOR3D -> {
                    //Not needed right now
                }
                case VECTOR6D -> {
                    double[] values = new double[6];
                    for (int j = 0; j < 6; j++) {
                        values[j] = buffer.getDouble();
                    }
                    variables.put(dataType,
                            new Pose(values[0], values[1], values[2],
                                    values[3], values[4], values[5]));

                }
                case VECTOR6INT32 -> {
                    //Not needed right now
                }
                case VECTOR6UINT32 -> {
                    //Not needed right now
                }

            }
        }
        return new DataPackage(PackageType.RTDE_DATA_PACKAGE, variables);
    }


    @Override
    public Map<DataType, Object> getPayload() {
        return payload;
    }
}
