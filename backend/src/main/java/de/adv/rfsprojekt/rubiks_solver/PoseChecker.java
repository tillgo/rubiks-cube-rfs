package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.ur.Utils;
import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.rtde.RTDE;
import de.adv.rfsprojekt.ur.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads.ActualTCPPose;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PoseChecker {

    private final RTDE rtde;


    public PoseChecker() throws Exception {
        rtde = new RTDE();
        setupRTDE();
    }


    private void setupRTDE() throws Exception {
        rtde.connect();
        List<DataType> outputVariables = List.of(DataType.ACTUAL_TCP_POSE);
        rtde.send_output_setup(outputVariables, 5);
        rtde.sendStart();
    }

    public void waitTilReachedEndPosition(Pose endPose) throws Exception {
        Package[] recievedPackages;
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE};
        int correctnessCounter = 0;
        while (true) {
            recievedPackages = rtde.receiveMultiplePackages(packageTypes);
            DataPackage dataPackage = (DataPackage) recievedPackages[0];
            if (dataPackage != null) {
                ActualTCPPose actualPose = (ActualTCPPose) dataPackage.getPayload().get(DataType.ACTUAL_TCP_POSE);
                if (actualPose != null) {
                    System.out.println(actualPose.getPayload());
                    correctnessCounter = Utils.comparePositions(endPose, actualPose.getPayload()) ? correctnessCounter + 1 : 0;
                }
            }
            if (correctnessCounter == 3) return;
        }
    }
}
