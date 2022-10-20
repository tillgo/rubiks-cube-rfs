package de.adv.rfsprojekt.rest;

import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.entities.Pose;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("manual")
public class ManualControlResource {

    @Inject
    UR ur;

    @POST
    @Path("forward")
    public String moveForward() throws Exception {
        ur.powerOn();

        //1cm nach vorne
        Pose forwardPos = new Pose(0.01, 0, 0, 0, 0, 0);

        return ur.buildScript()
                .moveRelativeToTCP(forwardPos)
                .executeWithMessage();



    }





}
