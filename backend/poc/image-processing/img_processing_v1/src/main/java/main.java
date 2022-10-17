import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main {

    private static String IMAGES_PATH = "./src/main/resources/images/";
    private static String CUBE_NORMAL_PATH = IMAGES_PATH + "cube_normal.jpg";
    private static String CUBE_BLITZ_PATH = IMAGES_PATH + "cube_blitz.jpg";


    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageIO.read(new File(CUBE_NORMAL_PATH));
        Analyzer analyzer = new Analyzer(img);
        analyzer.analyze();
    }
}
