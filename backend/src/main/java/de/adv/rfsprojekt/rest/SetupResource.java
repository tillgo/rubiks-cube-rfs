package de.adv.rfsprojekt.rest;

import de.adv.rfsprojekt.ur.UR;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("setup")
public class SetupResource {

    @Inject
    UR ur;

    @POST
    @Path("startup")
    public void startup() throws Exception {
        ur.connect();
        ur.powerOn();
        Thread.sleep(1000);

    }

    @POST
    @Path("shutdown")
    public void shutdown() throws Exception {
        ur.disconnect();
        ur.powerOff();
    }
}
