package de.adv.rfsprojekt.service.shared;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur_new.rtde.RTDE;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.MessagePacket;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatus;
import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.data_payloads.SafetyStatusType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ErrorAnalyzer extends Thread {

    private final Consumer<DataPackage> broadcast;
    private final RTDE rtde;

    public ErrorAnalyzer(Consumer<DataPackage> broadcast) {
        this.broadcast = broadcast;
        rtde = new RTDE(Config.getURHost());
    }

    @Override
    public void run(){
        try {
            analyzeError();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void analyzeError() throws Exception {
        rtde.connect();
        List<DataType> outputVariables = Arrays.asList(DataType.SAFETY_STATUS);
        rtde.send_output_setup(outputVariables, 125);
        rtde.sendStart();
        Thread.sleep(10);
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE};
        Package[] recievedPackages = null;
        while (true) {
            recievedPackages = rtde.reveiveMultiplePackages(packageTypes);
            DataPackage dataPackage = (DataPackage) recievedPackages[0];
            if (dataPackage != null) {
                SafetyStatus safetyStatus = (SafetyStatus) dataPackage.getPayload().get(DataType.SAFETY_STATUS);
                broadcast.accept(dataPackage);
            }
        }
    }
}
