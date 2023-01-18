package de.adv.rfsprojekt.util;

public enum CubeColor {
    YELLOW('Y', 'D'),
    GREEN('G', 'F'),
    RED('R', 'R'),
    ORANGE('O', 'L'),
    WHITE('W', 'T'),
    BLUE('B', 'B');

    private final char color;

    private final char position;

    CubeColor(char color, char position) {
        this.color = color;
        this.position = position;
    }

    public char getColor() {
        return color;
    }

    public char getPosition() {
        return position;
    }
}
