package de.adv.rfsprojekt.ur_new.entities;

import static de.adv.rfsprojekt.ur.UR.DECIMAL_FORMAT;

public class Pose {

    private Position position;

    private Orientation orientation;

    public Pose() {
        position = new Position();
        orientation = new Orientation();
    }

    public Pose(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Pose(double x, double y, double z, double ox, double oy, double oz) {
        this.position = new Position(x, y, z);
        this.orientation = new Orientation(ox, oy, oz);

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() { // DO NOT CHANGE
        StringBuilder sb = new StringBuilder();
        sb.append("p[")
                .append(DECIMAL_FORMAT.format(position.getX())).append(',')
                .append(DECIMAL_FORMAT.format(position.getY())).append(',')
                .append(DECIMAL_FORMAT.format(position.getZ())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getX())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getY())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getZ())).append(']');
        return sb.toString();
    }

    public String toStringArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[")
                .append(DECIMAL_FORMAT.format(position.getX())).append(',')
                .append(DECIMAL_FORMAT.format(position.getY())).append(',')
                .append(DECIMAL_FORMAT.format(position.getZ())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getX())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getY())).append(',')
                .append(DECIMAL_FORMAT.format(orientation.getZ())).append(']');
        return sb.toString();
    }
}
