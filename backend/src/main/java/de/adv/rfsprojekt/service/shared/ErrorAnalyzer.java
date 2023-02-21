package de.adv.rfsprojekt.service.shared;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur.rtde.RTDE;
import de.adv.rfsprojekt.ur.rtde.entities.packages.Package;
import de.adv.rfsprojekt.ur.rtde.entities.packages.PackageType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataPackage;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.DataType;
import de.adv.rfsprojekt.ur.rtde.entities.packages.data.data_payloads.SafetyStatus;
import de.adv.rfsprojekt.websocket.entities.RoboStatusInfoMessage;
import de.adv.rfsprojekt.websocket.entities.RoboStatusInfoPayload;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;

import java.util.List;
import java.util.function.Consumer;

public class ErrorAnalyzer extends Thread {

    private final Consumer<WebsocketMessage<RoboStatusInfoPayload>> broadcast;
    private final RTDE rtde;

    private boolean doRun = true;

    public ErrorAnalyzer(Consumer<WebsocketMessage<RoboStatusInfoPayload>> broadcast) {
        this.broadcast = broadcast;
        rtde = new RTDE(Config.getURHost());
    }

    @Override
    public void run() {
        try {
            analyzeError();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void kill() {
        doRun = false;
    }


    private void analyzeError() throws Exception {
        rtde.connect();
        List<DataType> outputVariables = List.of(DataType.SAFETY_STATUS);
        rtde.send_output_setup(outputVariables, 10);
        rtde.sendStart();
        Thread.sleep(10);
        PackageType[] packageTypes = {PackageType.RTDE_DATA_PACKAGE};
        Package[] recievedPackages = null;
        while (doRun) {
            recievedPackages = rtde.reveiveMultiplePackages(packageTypes);
            DataPackage dataPackage = (DataPackage) recievedPackages[0];
            if (dataPackage != null) {
                SafetyStatus safetyStatus = (SafetyStatus) dataPackage.getPayload().get(DataType.SAFETY_STATUS);
                broadcast.accept(new RoboStatusInfoMessage(new RoboStatusInfoPayload(safetyStatus.getPayload())));
            }
        }
    }
}
