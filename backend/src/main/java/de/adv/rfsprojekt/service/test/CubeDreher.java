package de.adv.rfsprojekt.service.test;

import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.urscript_commands.MovementCommands;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class CubeDreher {


    @Inject
    UR ur;
    private final Pose greifSeitwaerts = new Pose(-0.2196, -0.6726, 0.3556, 2.902, -1.199,0);
    private final Pose greifHoeher = new Pose(-0.2196, -0.67246, 0.400, 2.902, -1.199, 0);
    private final Pose fallenLasser = new Pose(-0.0887,-0.5439,0.1869,1.48,-0.6, -0.63);
    private final Pose fallenLasserHoeher = new Pose(-0.0887,-0.5439,0.240,1.48,-0.6, -0.63);




    public void dreheWuerfel() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(MovementCommands.MOVE_L(greifHoeher, 1, 0.2,0,0) +";");
        sb.append(MovementCommands.MOVE_L(greifSeitwaerts, 1, 0.2,0,0) +";");
        sb.append(MovementCommands.MOVE_L(fallenLasser, 1, 0.2,0,0) +";");
        sb.append(MovementCommands.MOVE_L(fallenLasserHoeher, 1, 0.2,0,0) +";");

        ur.buildScript().customScript(sb.toString()).execute();
    }
}
