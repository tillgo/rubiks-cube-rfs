package de.adv.rfsprojekt.images;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.util.CubeColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analyzer {

    private final BufferedImage imageToAnalyze;

    public Analyzer(BufferedImage imageToAnalyze) {
        this.imageToAnalyze = imageToAnalyze;
    }

    public List<String> analyze() {
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

        System.out.println(hue + " " + bright + " " + sat);

        var ranges = Config.getHSBRanges();
        return ranges.entrySet().stream()
                .filter(e -> isColor(e.getValue(), hue, sat, bright))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    public Color averageColor(int x0, int y0, int radius) {
        int x1 = x0 - radius;
        int y1 = y0 - radius;
        int x2 = x0 + radius;
        int y2 = y0 + radius;
        int sumr = 0, sumg = 0, sumb = 0;
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                var pixel = new Color(imageToAnalyze.getRGB(x, y));
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();
            }
        }
        int num = (int) Math.pow(radius * 2, 2);
        return new Color(sumr / num, sumg / num, sumb / num);
    }

    private float[] getHSB(Point point){
        var color = averageColor(point.x(),point.y(), 25);
        System.out.println(color);
        return Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), new float[3]);
    }

    private boolean isColor(HSBRanges ranges, float hue, float sat, float bright) {
        var hueR = ranges.hue();
        var brightR = ranges.brightness();
        var satR = ranges.saturation();

        var isOverflow = hueR.max() < hueR.min();
        var hueFits = isOverflow ? hue < hueR.max() || hue >= hueR.min() : hue >= hueR.min() && hue < hueR.max();

        return hueFits && sat >= satR.min() && sat < satR.max() && bright >= brightR.min() && bright < brightR.max();
    }

}
