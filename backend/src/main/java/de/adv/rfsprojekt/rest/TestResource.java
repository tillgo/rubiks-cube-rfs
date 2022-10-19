package de.adv.rfsprojekt.rest;

import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.utils.JointPosition;
import de.adv.rfsprojekt.ur.utils.Pose;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Test Endpoint for random shit lol
 */
@Path("test")
public class TestResource {

    @Inject
    UR ur;

    @Path("1")
    @POST
    public Pose testConnection() throws Exception {
        ur.connect();
        ur.powerOn();

        Thread.sleep(1000);
        var pose = ur.getPose();

        ur.movel(new JointPosition(), 1f, 0.2f, 0, 0);
        ur.waitFor(new JointPosition(), 0.01);

        ur.powerOff();
        ur.disconnect();
        return pose;
    }
}
