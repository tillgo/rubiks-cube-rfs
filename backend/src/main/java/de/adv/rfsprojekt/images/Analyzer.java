package de.adv.rfsprojekt.images;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.util.CubeColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analyzer {

    private final BufferedImage imageToAnalyze;

    public Analyzer(BufferedImage imageToAnalyze) {
        this.imageToAnalyze = Pixelator.pixelate(imageToAnalyze);
    }

    public List<String> analyze() throws IOException {
        String IMAGES_PATH = "./src/main/resources/images/";
        File outputFile = new File(IMAGES_PATH + "test.jpg");
        ImageIO.write(imageToAnalyze, "jpg",outputFile);
        return Config.getPositions().stream()
                .map(this::getColorName)
                .map(Objects::toString)
                .toList();
    }


    private CubeColor getColorName(Point point){
        float[] hsb = getHSB(point);
        float hue = hsb[0]*360;
        float sat = hsb[1] * 100;
        float bright = hsb[2] * 100;

        System.out.println(hue);

        var ranges = Config.getHSBRanges();
        return ranges.entrySet().stream()
                .filter(e -> isColor(e.getValue(), hue, sat, bright))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    private float[] getHSB(Point point){
        imageToAnalyze.getColorModel();
        var color = new java.awt.Color(imageToAnalyze.getRGB(point.x(),point.y()));
        return java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), new float[3]);
    }

    private boolean isColor(HSBRanges ranges, float hue, float sat, float bright) {
        var hueR = ranges.hue();
        var brightR = ranges.brightness();
        var satR = ranges.saturation();

        var isOverflow = hueR.max() <= hueR.min();
        var hueFits = isOverflow ? hue >= hueR.max() || hue < hueR.min() : hue >= hueR.min() && hue < hueR.max();

        return hueFits && sat >= satR.min() && sat < satR.max() && bright >= brightR.min() && bright < brightR.max();
    }

}
