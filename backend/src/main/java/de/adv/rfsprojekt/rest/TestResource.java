package de.adv.rfsprojekt.rest;


import de.adv.rfsprojekt.images.Analyzer;
import de.adv.rfsprojekt.images.ImageService;
import de.adv.rfsprojekt.service.test.CubeDreher;
import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.util.CubeColor;

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

    @Inject
    ImageService imageService;

    @Inject CubeDreher cubeDreher;

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
    public List<CubeColor> imageprocc() throws IOException {
        BufferedImage img = ImageIO.read(new File("./src/main/resources/images/gelb_unscharf.jpg"));
        Analyzer analyzer = new Analyzer();
        return analyzer.analyze(img);
    }

    @Path("4")
    @GET
    public List<CubeColor> imageService() {
        // 52.3 -497.25 208.2 1.25 -2.96 0.97
        System.out.println("_________________________");
        return imageService.getCurrentCubeColors();
    }

    @Path("cube-dreher")
    @GET
    public void cuberDreher() throws IOException {
        cubeDreher.dreheWuerfel();
    }


}

