package de.adv.rfsprojekt.ur_new.entities;


import static de.adv.rfsprojekt.ur_new.Utils.DECIMAL_FORMAT;

public record JointPose(int base, int shoulder, int elbow, int wrist1, int wrist2, int wrist3) {


    @Override
    public String toString() { // Do not Change!!!
        StringBuilder sb = new StringBuilder();
        sb.append("q[")
                .append(DECIMAL_FORMAT.format(base)).append(',')
                .append(DECIMAL_FORMAT.format(shoulder)).append(',')
                .append(DECIMAL_FORMAT.format(elbow)).append(',')
                .append(DECIMAL_FORMAT.format(wrist1)).append(',')
                .append(DECIMAL_FORMAT.format(wrist2)).append(',')
                .append(DECIMAL_FORMAT.format(wrist3)).append(']');
        return sb.toString();
    }
}
