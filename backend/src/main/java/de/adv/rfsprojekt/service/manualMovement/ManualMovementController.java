package de.adv.rfsprojekt.service.manualMovement;

import de.adv.rfsprojekt.service.manualMovement.models.GripperMove;
import de.adv.rfsprojekt.service.manualMovement.models.RoboArmMove;
import de.adv.rfsprojekt.service.manualMovement.models.RoboMove;
import de.adv.rfsprojekt.service.manualMovement.models.RoboToolMove;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManualMovementController {

    public void excecuteMove(RoboMove roboMove) {
        if (roboMove instanceof RoboArmMove ram) {
            executeRoboArmMove(ram);
        } else if (roboMove instanceof RoboToolMove rtm) {
            executeRoboToolMove(rtm);
        } else if (roboMove instanceof GripperMove gm) {
            executeGripperMove(gm);
        }
    }


    private void executeRoboArmMove(RoboArmMove roboArmMove) {

    }

    private void executeRoboToolMove(RoboToolMove roboToolMove) {

    }

    private void executeGripperMove(GripperMove gripperMove) {

    }


}
