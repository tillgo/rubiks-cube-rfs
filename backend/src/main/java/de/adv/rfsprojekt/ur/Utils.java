package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.Pose;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Utils {
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.#################", new DecimalFormatSymbols(Locale.US));

    public static boolean comparePositions(Pose pose1, Pose pose2) {
        double toleranz = 0.00005;
        return Math.abs(pose1.getPosition().getX() - pose2.getPosition().getX()) < toleranz
                && Math.abs(pose1.getPosition().getY() - pose2.getPosition().getY()) < toleranz
                && Math.abs(pose1.getPosition().getZ() - pose2.getPosition().getZ()) < toleranz
                && Math.abs(pose1.getOrientation().getX() - pose2.getOrientation().getX()) < toleranz
                && Math.abs(pose1.getOrientation().getY() - pose2.getOrientation().getY()) < toleranz
                && Math.abs(pose1.getOrientation().getZ() - pose2.getOrientation().getZ()) < toleranz;


    }
}
