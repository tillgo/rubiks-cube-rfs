package de.adv.rfsprojekt.rest;


import de.adv.rfsprojekt.images.Analyzer;
import de.adv.rfsprojekt.ur_new.UR;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @Path("3")
    @GET
    public List<String> imageprocc() throws IOException {
        BufferedImage img = ImageIO.read(new File("./src/main/resources/images/gruen.jpg"));
        Analyzer analyzer = new Analyzer(img);
        return analyzer.analyze();
    }


}

