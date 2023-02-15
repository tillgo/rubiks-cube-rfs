package de.adv.rfsprojekt.service.test;

import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.entities.JointPose;
import de.adv.rfsprojekt.ur_new.entities.Pose;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class CubeDreher {


    @Inject
    UR ur;
    private final Pose greifSeitwaerts = new Pose(-0.2196, -0.6726, 0.3556, 2.902, -1.199, 0);
    private final Pose greifHoeher = new Pose(-0.2196, -0.67246, 0.400, 2.902, -1.199, 0);
    private final Pose fallenLasser = new Pose(-0.0887, -0.5439, 0.1869, 1.48, -0.6, -0.63);
    private final Pose fallenLasserHoeher = new Pose(-0.0887, -0.5439, 0.240, 1.48, -0.6, -0.63);


    public void dreheWuerfel() throws IOException {
        ur.buildScript()
                .moveL(greifHoeher)
                .moveL(greifSeitwaerts)
                .moveL(fallenLasser)
                .moveL(fallenLasserHoeher)
                .moveRelativeToTCP(new JointPose(0, 3, 0, 0, 0, 0))
                .execute();
    }
}
