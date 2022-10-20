package de.adv.rfsprojekt.rest;

import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.utils.Pose;
import de.adv.rfsprojekt.ur.utils.Vec3;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("manual")
public class ManualControlResource {

    @Inject
    UR ur;

    @POST
    @Path("forward")
    public void moveForward() throws Exception {


        for(int i = 0; i<10000000; i++){
            ur.connect();
            var currPose = ur.getPose();
            var addPose = new Pose();
            addPose.setPosition(new Vec3(0.01,0,0));
            currPose.add(addPose);
            ur.movel(currPose, 1f, 0.2f, 0 ,0 );
            ur.waitFor(currPose, 0.01);
            ur.disconnect();
        }


    }





}
