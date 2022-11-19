package de.adv.rfsprojekt.ur_new.rtde;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.MessagePacket;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatus;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatusType;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        RTDE rtde = new RTDE("192.168.2.40");
        rtde.connect();
        List<DataType> outputVariables = Arrays.asList(DataType.ACTUAL_TCP_POSE, DataType.SAFETY_STATUS);
        rtde.send_output_setup(outputVariables, 125);
        rtde.sendStart();
        Thread.sleep(10);
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE, PackageType.RTDE_TEXT_MESSAGE};
        Package[] recievedPackages = null;
        while (true) {
            recievedPackages = rtde.reveiveMultiplePackages(packageTypes);
            DataPackage dataPackage = (DataPackage) recievedPackages[0];
            if (dataPackage != null) handleDataPackage(dataPackage);
            MessagePacket messagePacket = (MessagePacket) recievedPackages[1];
            if (messagePacket != null) System.out.println(messagePacket.getPayload());

        }

    }

    public static void handleDataPackage(DataPackage dataPackage) {
        SafetyStatus safetyStatus = (SafetyStatus) dataPackage.getPayload().get(DataType.SAFETY_STATUS);
        if (safetyStatus != null) {
            for (SafetyStatusType type : safetyStatus.getPayload().keySet()) {
                System.out.println(type + ": " + safetyStatus.getPayload().get(type));
            }
        }
    }
}
