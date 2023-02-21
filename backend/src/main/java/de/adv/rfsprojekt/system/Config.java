package de.adv.rfsprojekt.system;

import de.adv.rfsprojekt.images.HSBRanges;
import de.adv.rfsprojekt.images.Point;
import de.adv.rfsprojekt.images.Range;
import de.adv.rfsprojekt.ur.entities.Pose;
import de.adv.rfsprojekt.util.CubeColor;
import org.eclipse.microprofile.config.ConfigProvider;

import java.util.Arrays;
import java.util.List;
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

    public static String getURHost() {
        return ConfigProvider.getConfig().getValue("ur.hostname", String.class);
    }

    public static int getURSecondaryPort() {
        return ConfigProvider.getConfig().getValue("ur.secondary_port", Integer.class);
    }

    public static int getURRTDEPort() {
        return ConfigProvider.getConfig().getValue("ur.rtde_port", Integer.class);
    }

    public static List<Point> getPositions() {
        return List.of(
                new Point(getPos("top-left.xpos"), getPos("top-left.ypos")),
                new Point(getPos("top-mid.xpos"), getPos("top-mid.ypos")),
                new Point(getPos("top-right.xpos"), getPos("top-right.ypos")),
                new Point(getPos("mid-left.xpos"), getPos("mid-left.ypos")),
                new Point(getPos("mid-mid.xpos"), getPos("mid-mid.ypos")),
                new Point(getPos("mid-right.xpos"), getPos("mid-right.ypos")),
                new Point(getPos("bottom-left.xpos"), getPos("bottom-left.ypos")),
                new Point(getPos("bottom-mid.xpos"), getPos("bottom-mid.ypos")),
                new Point(getPos("bottom-right.xpos"), getPos("bottom-right.ypos"))
        );
    }

    public static Map<CubeColor, HSBRanges> getHSBRanges() {
        return Map.of(
                CubeColor.WHITE, getColorRanges("white"),
                CubeColor.YELLOW, getColorRanges("yellow"),
                CubeColor.BLUE, getColorRanges("blue"),
                CubeColor.RED, getColorRanges("red"),
                CubeColor.GREEN, getColorRanges("green"),
                CubeColor.ORANGE, getColorRanges("orange")
        );
    }

    public static Pose SCANNER_POSE = getPose("scanner");
    public static Pose GREIF_POSE = getPose("greif");
    public static Pose GREIF_HOCH_POSE = getPose("greif-hoch");
    public static Pose DROP_POSE = getPose("drop");
    public static Pose DROP_HOCH_POSE = getPose("drop-hoch");

    public static Pose getPose(String name) {
        var conf = ConfigProvider.getConfig();
        var value = conf.getValue("ur.default-pose.\"" + name + "\"", String.class);

        var values = Arrays.stream(value.split(";"))
                .map(Double::valueOf)
                .toList();

        return new Pose(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5));
    }

    private static int getPos(String name) {
        return ConfigProvider.getConfig().getOptionalValue("scan." + name, Integer.class).orElse(1);
    }

    private static HSBRanges getColorRanges(String name) {
        var conf = ConfigProvider.getConfig();
        return new HSBRanges(
                new Range(conf.getOptionalValue(name + ".hue.min", Integer.class).orElse(0), conf.getOptionalValue(name + ".hue.max", Integer.class).orElse(360)),
                new Range(conf.getOptionalValue(name + ".sat.min", Integer.class).orElse(0), conf.getOptionalValue(name + ".sat.max", Integer.class).orElse(100)),
                new Range(conf.getOptionalValue(name + ".bright.min", Integer.class).orElse(0), conf.getOptionalValue(name + ".bright.max", Integer.class).orElse(100))
        );
    }
}
