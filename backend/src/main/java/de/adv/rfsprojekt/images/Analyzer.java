package de.adv.rfsprojekt.images;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.util.CubeColor;

import javax.enterprise.context.ApplicationScoped;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class Analyzer {

    public List<CubeColor> analyze(BufferedImage image) {
        return Config.getPositions().stream()
                .map(p -> getColorName(p, image))
                .toList();
    }


    private CubeColor getColorName(Point point, BufferedImage image){
        float[] hsb = getHSB(point, image);
        float hue = hsb[0]*360;
        float sat = hsb[1] * 100;
        float bright = hsb[2] * 100;

        System.out.println(hue + " " + sat + " " + bright);

        var ranges = Config.getHSBRanges();
        return ranges.entrySet().stream()
                .filter(e -> isColor(e.getValue(), hue, sat, bright))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    public Color averageColor(int x0, int y0, int radius, BufferedImage image) {
        int x1 = x0 - radius;
        int y1 = y0 - radius;
        int x2 = x0 + radius;
        int y2 = y0 + radius;
        int sumr = 0, sumg = 0, sumb = 0;
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                var pixel = new Color(image.getRGB(x, y));
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();
            }
        }
        int num = (int) Math.pow(radius * 2 + 1, 2);
        return new Color(sumr / num, sumg / num, sumb / num);
    }

    private float[] getHSB(Point point, BufferedImage image){
        var color = averageColor(point.x(),point.y(), 25, image);
        return java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), new float[3]);
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
