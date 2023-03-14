package de.adv.rfsprojekt.Präsentation;

import de.adv.rfsprojekt.rubiks_solver.PoseChecker;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.URImpl;
import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import de.adv.rfsprojekt.ur.urscript_builder.URScriptBuilderImpl;

public class URLibrary_Example {


    public static void main(String[] args) throws Exception {
        Pose a = new Pose(0.2, 0.145, 0.223, 1.34, 2.3, -0.23);
        Pose b = new Pose(0.4, -0.2548, 0.134, 2.1, 0.22, -1.23);

        URScript scriptHin = new URScriptBuilderImpl()
                .moveLZAxis(400)
                .openGripper()
                .moveJ(a)
                .closeGripper()
                .moveJ(b)
                .openGripper()
                .getURScript();

        URScript scriptZurueck = new URScriptBuilderImpl()
                .moveJ(a)
                .getURScript();

        var poseChecker = new PoseChecker();
        UR ur = new URImpl();
        ur.powerOn();
        ur.execute(scriptHin);
        poseChecker.waitTilReachedEndPosition(b);
        ur.execute(scriptZurueck);


    }
}
