package de.adv.rfsprojekt.util;

public enum CubeColor {
    YELLOW("Y", "D"),
    GREEN("G", "F"),
    RED("R", "R"),
    ORANGE("O", "L"),
    WHITE("W", "U"),
    BLUE("B", "B");

    private final String color;

    private final String position;

    CubeColor(String color, String position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }
}
