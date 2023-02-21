package de.adv.rfsprojekt.rest;


import de.adv.rfsprojekt.images.ImageService;
import de.adv.rfsprojekt.rubiks_solver.RubiksCommander;
import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScriptBuilderImpl;
import de.adv.rfsprojekt.util.CubeColor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Test Endpoint for random shit lol
 */
@Path("test")
public class TestResource {

    @Inject
    UR ur;

    @Inject
    ImageService imageService;

    @Inject
    RubiksCommander rubiksCommander;

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
        ur.execute(new URScriptBuilderImpl().moveRelativeToTCP(new de.adv.rfsprojekt.ur_new.entities.Pose()).getURScript());

    }

    @Path("3")
    @GET
    public void test3() throws IOException {
        System.out.println(Config.getPose("scanner"));
    }

    @Path("4")
    @GET
    public List<CubeColor> imageService() {
        // 52.3 -497.25 208.2 1.25 -2.96 0.97
        System.out.println("_________________________");
        return imageService.getCurrentCubeColors();
    }

    @Path("solve-test")
    @GET
    public Response cuberDreher() throws Exception {
        rubiksCommander.solveCube();
        return Response.ok().build();
    }


}

