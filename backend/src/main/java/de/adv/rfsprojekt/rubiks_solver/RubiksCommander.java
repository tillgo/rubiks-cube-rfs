package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.websocket.entities.RubiksSolverCommandPayload;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RubiksCommander {
    @Inject
    RubiksCalculator rubiksCalculator;
    @Inject
    RubiksSolver rubiksSolver;


    public void executeCommand(RubiksSolverCommandPayload commandPayload) throws Exception {
        switch (commandPayload.getCommandType()) {
            //ToDo Roboter Ficken
            case STOP -> {
                break;
            }
            case START_SCAN -> analyzeRubiksCube();
            case START_SOLVE -> solveCube();

        }
    }

    public void analyzeRubiksCube() {

    }

    public void solveCube() throws Exception {
        String unsolvedCube = "URBLURRLRUFDBRBBULDUBLFRBFLDUUDDBFBDRFFDLDURRLUFLBFFDL";
        var moves = rubiksCalculator.calculateSolvingPath(unsolvedCube);
        var scriptMoves = rubiksCalculator.getScriptsForMoves(moves);
        rubiksSolver.solve(scriptMoves, moves);
    }


}
