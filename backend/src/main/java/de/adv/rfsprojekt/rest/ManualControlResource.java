package de.adv.rfsprojekt.rest;

import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScriptBuilderImpl;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("manual")
public class ManualControlResource {

    @Inject
    UR ur;

    @POST
    @Path("positivex")
    public void movePositiveX() throws Exception {
        //1cm in positive X-Richtung
        Pose forwardPos = new Pose(0.01, 0, 0, 0, 0, 0);
        ur.execute(new URScriptBuilderImpl().moveRelativeToTCP(forwardPos).getURScript());
    }

    @POST
    @Path("negativex")
    public void moveNegativeX() throws Exception {
        //1cm in negative X-Richtung
        Pose backwardPos = new Pose(0.01, 0, 0, 0, 0, 0);
    }


}
