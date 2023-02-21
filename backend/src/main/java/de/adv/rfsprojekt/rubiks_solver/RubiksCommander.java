package de.adv.rfsprojekt.rubiks_solver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class RubiksCommander {
    @Inject
    RubiksCalculator rubiksCalculator;
    @Inject
    RubiksSolver rubiksSolver;

    public void analyzeRubiksCube() {

    }

    public void solveCube() throws IOException, InterruptedException {
        String unsolvedCube = "URBLURRLRUFDBRBBULDUBLFRBFLDUUDDBFBDRFFDLDURRLUFLBFFDL";
        var moves = rubiksCalculator.calculateSolvingPath(unsolvedCube);
        var scriptMoves = rubiksCalculator.getScriptsForMoves(moves);
        rubiksSolver.solve(scriptMoves, moves);
    }


}
