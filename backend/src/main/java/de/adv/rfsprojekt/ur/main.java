package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import de.adv.rfsprojekt.ur.urscript_builder.URScriptBuilderImpl;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {


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
