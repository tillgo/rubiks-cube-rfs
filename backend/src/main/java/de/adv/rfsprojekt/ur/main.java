package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.rtde.RTDE;
import de.adv.rfsprojekt.ur.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.VariableType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads.SafetyStatus;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import de.adv.rfsprojekt.ur.urscript_builder.URScriptBuilderImpl;

import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {

        RTDE rtde = new RTDE();
        rtde.connect();
        List<VariableType> outputVariables = List.of(VariableType.SAFETY_STATUS);
        rtde.sendOutputSetup(outputVariables, 10);
        rtde.sendStart();
        Thread.sleep(10);
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE};
        Package[] recievedPackages = null;
        recievedPackages = rtde.receiveMultiplePackages(packageTypes);
        DataPackage dataPackage = (DataPackage) recievedPackages[0];
        if (dataPackage != null) {
            SafetyStatus safetyStatus = (SafetyStatus) dataPackage.getPayload().get(VariableType.SAFETY_STATUS);
        }


        Pose poseA = new Pose(-0.1938, -0.65895, 0.3538, 3.339, -1.374, 0.28);
        Pose poseB = new Pose(-0.0876, -0.5452, 0.1864, 1.48, -0.6, -0.64);

        URScript script = new URScriptBuilderImpl()
                .moveJ(poseA)
                .openGripper()
                .moveLZAxis(-0.05)
                .closeGripper()
                .moveJ(poseB)
                .moveLZAxis(-0.05)
                .openGripper()
                .getURScript();


        new URImpl().execute(script);


    }
}
