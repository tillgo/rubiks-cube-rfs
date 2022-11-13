package de.adv.rfsprojekt.rest;


import de.adv.rfsprojekt.ur_new.UR;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;

/**
 * Test Endpoint for random shit lol
 */
@Path("test")
public class TestResource {

    @Inject
    UR ur;

    @Path("1")
    @POST
    public void testConnection() throws Exception {

    }

    /**
     * Test own UR-Library
     */
    @Path("2")
    @POST
    public void testNewLib() throws IOException, InterruptedException {

        ur.powerOn();
        ur.buildScript().moveRelativeToTCP(new de.adv.rfsprojekt.ur_new.entities.Pose()).execute();

    }


}

