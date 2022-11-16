package de.adv.rfsprojekt.service.manualMovement;

import com.google.gson.Gson;
import de.adv.rfsprojekt.service.manualMovement.models.*;
import de.adv.rfsprojekt.ur_new.UR;

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
    public void executeMove(String roboCommandMessage) throws IOException, InterruptedException {
        Gson gson = new Gson();
        RoboComand roboCommand = gson.fromJson(roboCommandMessage, RoboComand.class);
        CommandType commandType = roboCommand.getCommandType();

        switch (commandType) {
            case ROBO_ARM -> executeRoboArmCommand(gson.fromJson(roboCommandMessage, RoboArmCommand.class));
            case ROBO_TOOL -> executeRoboToolCommand(gson.fromJson(roboCommandMessage, RoboToolCommand.class));
            case GRIPPER -> executeGripperCommand(gson.fromJson(roboCommandMessage, GripperCommand.class));
            case ROBO_SETUP -> executeRoboSetupCommand(gson.fromJson(roboCommandMessage, RoboSetupCommand.class));

        }
    }


    private void executeRoboSetupCommand(RoboSetupCommand setupCommand) throws IOException, InterruptedException {
        switch (setupCommand.getCommand()){
            case ON -> ur.powerOn();
            case OFF -> ur.powerOff();
        }
    }

    private void executeRoboArmCommand(RoboArmCommand roboArmMove) throws IOException {
        ur.buildScript().speedL(roboArmMove.getCommand().getPose()).execute();
    }

    private void executeRoboToolCommand(RoboToolCommand roboToolMove) throws IOException {
        ur.buildScript().speedL(roboToolMove.getCommand().getPose()).execute();
    }

    private void executeGripperCommand(GripperCommand gripperCommand) throws IOException, InterruptedException {
        switch (gripperCommand.getCommand()) {
            case OPEN -> ur.commandGripper().open();
            case CLOSE -> ur.commandGripper().close();
            case ACTIVATE -> ur.commandGripper().activate();
        }
    }

}
