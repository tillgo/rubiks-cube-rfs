package de.adv.rfsprojekt.rubiks_solver.models;

import de.adv.rfsprojekt.util.Face;

public class Move {

    private final Face face;

    //positive Zahl: CounterClockwise | negative Zahl: Cclockwise
    private final int count;


    public Move(Face face, String turnOrder) {
        this.face = face;
        if (turnOrder == null) count = -1;
        else if (turnOrder.equals("'")) count = 1;
        else count = 2;
    }

    public Face getFace() {
        return face;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Move{" +
                "face=" + face +
                ", count=" + count +
                '}';
    }
}
