package de.adv.rfsprojekt.util;

import java.util.List;

public class CubeFace {
    private final CubeColor[][] pieces;

    public CubeFace(List<CubeColor> cubeColors) {
        if (cubeColors.size() != 9) throw new RuntimeException("Must contain 9 Colors");
        pieces = new CubeColor[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                pieces[row][col] = cubeColors.get(row + col);
            }
        }
    }


}
