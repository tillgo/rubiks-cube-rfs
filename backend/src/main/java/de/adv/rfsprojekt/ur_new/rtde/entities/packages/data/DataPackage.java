package de.adv.rfsprojekt.ur_new.rtde.entities.packages.data;

import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.ActualTCPPose;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.DataPayload;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.RobotStatus;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatus;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPackage extends Package {

    private int reciepeID;
    private Map<DataType, DataPayload> payload;

    public DataPackage(int reciepeID, PackageType packageType, Map<DataType, DataPayload> payload) {
        super(packageType);
        this.payload = payload;
        this.reciepeID = reciepeID;
    }

    public static Package unpack(ByteBuffer buffer, DataConfig config) {
        Map<DataType, DataPayload> variables = new HashMap<>();
        List<VariableType> variableTypes = config.getVariableTypes();
        List<DataType> dataTypes = config.getDataTypes();
        int id = buffer.get();
        for (int i = 0; i < variableTypes.size(); i++) {

            VariableType variableType = variableTypes.get(i);
            DataType dataType = dataTypes.get(i);

            switch (variableType) {
                case BOOL -> {
                    //Not needed right now
                }
                case UNINT8 -> {
                    //Not needed right now
                }
                case UINT32 -> {
                    int intPayload = buffer.getInt();
                    if (dataType == DataType.SAFETY_STATUS)
                        variables.put(dataType, SafetyStatus.unpack(intPayload));
                    else if (dataType == DataType.ROBOT_STATUS) {
                        variables.put(dataType, RobotStatus.unpack(intPayload));
                    }
                }
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
                            new ActualTCPPose(new Pose(values[0], values[1], values[2],
                                    values[3], values[4], values[5])));

                }
                case VECTOR6INT32 -> {
                    //Not needed right now
                }
                case VECTOR6UINT32 -> {
                    //Not needed right now
                }

            }
        }
        return new DataPackage(id, PackageType.RTDE_DATA_PACKAGE, variables);
    }


    @Override
    public Map<DataType, DataPayload> getPayload() {
        return payload;
    }
}
