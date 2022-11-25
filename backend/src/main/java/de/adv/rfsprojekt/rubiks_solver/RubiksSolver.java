package de.adv.rfsprojekt.rubiks_solver;


import de.adv.rfsprojekt.rubiks_solver.min2phase.Search;
import de.adv.rfsprojekt.rubiks_solver.min2phase.Tools;

public class RubiksSolver {

    public RubiksSolver() {
    }

    private void calculateSolvingPath() {


    }

    public static void main(String[] args) {
        System.out.println(new Search().solution(Tools.randomCube(), 21, 10000000, 0, 0));
    }
}
