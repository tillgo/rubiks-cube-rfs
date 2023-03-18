package de.adv.rfsprojekt.ur.rtde;

import de.adv.rfsprojekt.ur.rtde.entities.packages.MessagePacket;
import de.adv.rfsprojekt.ur.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads.*;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        RTDE rtde = new RTDE();
        rtde.connect();
        List<DataType> outputVariables = Arrays.asList(DataType.ACTUAL_TCP_POSE, DataType.SAFETY_STATUS, DataType.ROBOT_STATUS);
        rtde.sendOutputSetup(outputVariables, 1);
        rtde.sendStart();
        Thread.sleep(10);
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE, PackageType.RTDE_TEXT_MESSAGE};
        Package[] recievedPackages = null;
        while (true) {
            recievedPackages = rtde.receiveMultiplePackages(packageTypes);
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
                // System.out.println(type + ": " + safetyStatus.getPayload().get(type));
                // System.out.println("------------------------------------------------");
            }
        }

        RobotStatus robotStatus = (RobotStatus) dataPackage.getPayload().get(DataType.ROBOT_STATUS);
        if (robotStatus != null) {
            for (RobotStatusType type : robotStatus.getPayload().keySet()) {
                System.out.println(type + ": " + robotStatus.getPayload().get(type));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }

        ActualTCPPose tcpPose = (ActualTCPPose) dataPackage.getPayload().get(DataType.ACTUAL_TCP_POSE);
        if (tcpPose != null) {
            System.out.println(tcpPose.getPayload());
        }
    }
}
