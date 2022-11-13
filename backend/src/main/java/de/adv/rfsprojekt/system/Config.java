package de.adv.rfsprojekt.system;

import de.adv.rfsprojekt.images.HSBRanges;
import de.adv.rfsprojekt.images.PlatePosition;
import de.adv.rfsprojekt.images.Point;
import de.adv.rfsprojekt.images.Range;
import de.adv.rfsprojekt.util.Color;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.Map;

public class Config {

    public static double getMoveSpeedArm() {
        return ConfigProvider.getConfig().getValue("ur.move.speed.arm", Double.class);
    }

    public static double getMoveSpeedTool() {
        return ConfigProvider.getConfig().getValue("ur.move.speed.tool", Double.class);
    }

    public static double getMoveTime() {
        return ConfigProvider.getConfig().getValue("ur.move.time", Double.class);
    }

    public static Map<PlatePosition, Point> getPositions() {
        return Map.of(
                PlatePosition.TOP_LEFT, new Point(getPos("top-left.xpos"), getPos("top-left.ypos")),
                PlatePosition.TOP_MID, new Point(getPos("top-mid.xpos"), getPos("top-mid.ypos")),
                PlatePosition.TOP_RIGHT, new Point(getPos("top-right.xpos"), getPos("top-right.ypos")),
                PlatePosition.MID_LEFT, new Point(getPos("mid-left.xpos"), getPos("mid-left.ypos")),
                PlatePosition.MID_MID, new Point(getPos("mid-mid.xpos"), getPos("mid-mid.ypos")),
                PlatePosition.MID_RIGHT, new Point(getPos("mid-right.xpos"), getPos("mid-right.ypos")),
                PlatePosition.BOTTOM_LEFT, new Point(getPos("bottom-left.xpos"), getPos("bottom-left.ypos")),
                PlatePosition.BOTTOM_MID, new Point(getPos("bottom-mid.xpos"), getPos("bottom-mid.ypos")),
                PlatePosition.BOTTOM_RIGHT, new Point(getPos("bottom-right.xpos"), getPos("bottom-right.ypos"))
        );
    }

    public static Map<Color, HSBRanges> getHSBRanges() {
        return Map.of(
                Color.WHITE, getColorRanges("white"),
                Color.YELLOW, getColorRanges("yellow"),
                Color.BLUE, getColorRanges("blue"),
                Color.RED, getColorRanges("red"),
                Color.GREEN, getColorRanges("green"),
                Color.ORANGE, getColorRanges("orange")
        );
    }

    private static int getPos(String name) {
        return ConfigProvider.getConfig().getValue("scan." + name, Integer.class);
    }

    private static HSBRanges getColorRanges(String name) {
        var conf = ConfigProvider.getConfig();
        return new HSBRanges(
                new Range(conf.getOptionalValue(name + "hue.min", Integer.class).orElse(0), conf.getOptionalValue(name + "hue.max", Integer.class).orElse(360)),
                new Range(conf.getOptionalValue(name + "sat.min", Integer.class).orElse(0), conf.getOptionalValue(name + "sat.max", Integer.class).orElse(100)),
                new Range(conf.getOptionalValue(name + "bright.min", Integer.class).orElse(0), conf.getOptionalValue(name + "bright.max", Integer.class).orElse(100))
        );
    }
}
