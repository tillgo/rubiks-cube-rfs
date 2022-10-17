import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analyzer {

    private Plate tl = new Plate(PlatePosition.TOP_LEFT, 6,9);
    private Plate tm = new Plate(PlatePosition.TOP_MID, 6,13);
    private Plate tr = new Plate(PlatePosition.TOP_RIGHT, 6,17);
    private Plate ml = new Plate(PlatePosition.MID_LEFT, 10,9);
    private Plate mm = new Plate(PlatePosition.MID_MID, 10,13);
    private Plate mr = new Plate(PlatePosition.MID_RIGHT, 10,17);
    private Plate bl = new Plate(PlatePosition.BOTTOM_LEFT, 14,9);
    private Plate bm = new Plate(PlatePosition.BOTTOM_MID, 14,13);
    private Plate br = new Plate(PlatePosition.BOTTOM_RIGHT, 14,17);

    private List<Plate> plates = new ArrayList<>();

    private BufferedImage imageToAnalyze;

    public Analyzer(BufferedImage imageToAnalyze) {
        this.imageToAnalyze = Pixelator.pixelate(imageToAnalyze);
        plates.add(tl);
        plates.add(tm);
        plates.add(tr);
        plates.add(ml);
        plates.add(mm);
        plates.add(mr);
        plates.add(bl);
        plates.add(bm);
        plates.add(br);
    }


    public void analyze() throws IOException {


        String IMAGES_PATH = "./src/main/resources/images/";
        File outputFile = new File(IMAGES_PATH + "test123.jpg");
        ImageIO.write(imageToAnalyze, "jpg",outputFile);

    }

    private Color getColor(Plate plate){
        System.out.println(plate);
       return new Color(imageToAnalyze.getRGB(plate.getPixelHeightPosition(),plate.getPixelWidthPosition()));

    }
}
