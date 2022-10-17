import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analyzer {

    private Plate tl = new Plate(PlatePosition.TOP_LEFT, 40,28);
    private Plate tm = new Plate(PlatePosition.TOP_MID, 54,28);
    private Plate tr = new Plate(PlatePosition.TOP_RIGHT, 70,28);
    private Plate ml = new Plate(PlatePosition.MID_LEFT, 40,39);
    private Plate mm = new Plate(PlatePosition.MID_MID, 54,39);
    private Plate mr = new Plate(PlatePosition.MID_RIGHT, 70,39);
    private Plate bl = new Plate(PlatePosition.BOTTOM_LEFT, 40,58);
    private Plate bm = new Plate(PlatePosition.BOTTOM_MID, 54,58);
    private Plate br = new Plate(PlatePosition.BOTTOM_RIGHT, 70,58);

    List<Plate> plates = List.of(tl, tm, tr, ml, mm, mr, bl, bm, br);

    private BufferedImage imageToAnalyze;

    public Analyzer(BufferedImage imageToAnalyze) {
        this.imageToAnalyze = Pixelator.pixelate(imageToAnalyze);

    }


    public void analyze() throws IOException {
        String IMAGES_PATH = "./src/main/resources/images/";
        File outputFile = new File(IMAGES_PATH + "test.jpg");
        ImageIO.write(imageToAnalyze, "jpg",outputFile);
        plates.stream().map(this::getColorName).forEach(System.out::println);
    }


    private String getColorName(Plate plate){
        float[] hsb = getColor(plate);
        float hue = hsb[0]*360;
        float sat = hsb[1] * 100;
        float bright = hsb[2] * 100;

        if(sat < 15 && bright > 85){
            return "White";
        }else if (hue > 120 && hue < 180){
            return "Green";
        }else if (hue > 180 && hue < 300){
            return "Blue";
        }else if (hue > 310 || hue < 25){
            System.out.println(hue);
            System.out.println(bright);
            System.out.println(sat);
            return "RED";
        }else if (hue > 25 && hue < 50){
            System.out.println(hue);
            System.out.println(bright);
            System.out.println(sat);
            return "Orange";
        }else if (hue > 50 && hue < 100){
            return "Yellow";
        }else {
            return "DEINE MOMA";
        }
    }

    private float[] getColor(Plate plate){
        System.out.println(plate);
        Color lost = new Color(imageToAnalyze.getRGB(plate.getPixelHeightPosition(),plate.getPixelWidthPosition()));
        return Color.RGBtoHSB(lost.getRed(), lost.getGreen(), lost.getBlue(), new float[3]);

    }


}
