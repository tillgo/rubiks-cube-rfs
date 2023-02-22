package de.adv.rfsprojekt.service.manualMovement;

import de.adv.rfsprojekt.service.manualMovement.models.GripperCommand;
import de.adv.rfsprojekt.service.manualMovement.models.RoboArmCommand;
import de.adv.rfsprojekt.service.manualMovement.models.RoboSetupCommand;
import de.adv.rfsprojekt.service.manualMovement.models.RoboToolCommand;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.urscript_builder.URScriptBuilderImpl;
import de.adv.rfsprojekt.websocket.entities.manualMovement.ManualMovementCommandPayload;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ManualMovementController {

    @Inject
    UR ur;

    /**
     * Je nach Befehlstyp wird anderer Objekttyp aus JSON erzeugt
     * ToDo Error-Message zurückgeben, falls Gson Error wirft
     **/
    public void executeMove(ManualMovementCommandPayload data) throws IOException, InterruptedException {
        switch (data.getCommandType()) {
            case ROBO_ARM -> executeRoboArmCommand(RoboArmCommand.valueOf(data.getCommand()));
            case ROBO_TOOL -> executeRoboToolCommand(RoboToolCommand.valueOf(data.getCommand()));
            case GRIPPER -> executeGripperCommand(GripperCommand.valueOf(data.getCommand()));
            case ROBO_SETUP -> executeRoboSetupCommand(RoboSetupCommand.valueOf(data.getCommand()));
        }
    }

    private void executeRoboSetupCommand(RoboSetupCommand setupCommand) throws IOException, InterruptedException {
        switch (setupCommand) {
            case ON -> ur.powerOn();
            case OFF -> ur.powerOff();
        }
    }

    private void executeRoboArmCommand(RoboArmCommand roboArmMove) throws IOException {
        ur.execute(new URScriptBuilderImpl().speedL(roboArmMove.getPose()).getURScript());

    }

    private void executeRoboToolCommand(RoboToolCommand roboToolMove) throws IOException {
        ur.execute(new URScriptBuilderImpl().speedL(roboToolMove.getPose()).getURScript());
    }

    private void executeGripperCommand(GripperCommand gripperCommand) throws IOException, InterruptedException {
        switch (gripperCommand) {
            case OPEN -> ur.execute(new URScriptBuilderImpl().openGripper().getURScript());
            case CLOSE -> ur.execute(new URScriptBuilderImpl().closeGripper().getURScript());
            case ACTIVATE -> {
                ur.execute(new URScriptBuilderImpl().activateGripper().getURScript());
                Thread.sleep(5000);
            }
        }
    }

}
