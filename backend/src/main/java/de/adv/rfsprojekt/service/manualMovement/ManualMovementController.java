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
    public void executeMove(String roboMoveMessage) throws IOException {
        Gson gson = new Gson();
        RoboMove roboMove = gson.fromJson(roboMoveMessage, RoboMove.class);
        MoveType moveType = roboMove.getMoveType();

        switch (moveType) {
            case ROBO_ARM -> executeRoboArmMove(gson.fromJson(roboMoveMessage, RoboArmMove.class));
            case ROBO_TOOL -> executeRoboToolMove(gson.fromJson(roboMoveMessage, RoboToolMove.class));
            case GRIPPER -> executeGripperMove(gson.fromJson(roboMoveMessage, GripperMove.class));

        }
    }


    private void executeRoboArmMove(RoboArmMove roboArmMove) throws IOException {
        ur.buildScript().speedL(roboArmMove.getMoveDirection().getPose()).execute();
    }

    private void executeRoboToolMove(RoboToolMove roboToolMove) {

    }

    private void executeGripperMove(GripperMove gripperMove) {

    }


}
