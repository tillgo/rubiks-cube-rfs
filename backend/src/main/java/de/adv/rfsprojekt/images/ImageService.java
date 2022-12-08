package de.adv.rfsprojekt.images;

import de.adv.rfsprojekt.util.CubeColor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@ApplicationScoped
public class ImageService {

    @ConfigProperty(name= "ur.camera.imagepath")
    String imagePath;

    @Inject
    Analyzer analyzer;

    public List<CubeColor> getCurrentCubeColors() {
        BufferedImage currentImage = null;
        try {
            currentImage = ImageIO.read(new URL(imagePath));
            String IMAGES_PATH = "./src/main/resources/images/";
            File outputFile = new File(IMAGES_PATH + "test.jpg");
            ImageIO.write(currentImage, "jpg",outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return analyzer.analyze(currentImage);
    }
}
