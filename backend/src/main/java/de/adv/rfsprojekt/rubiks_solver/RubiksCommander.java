package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.rubiks_solver.models.ScanCompleteInfo;
import de.adv.rfsprojekt.websocket.entities.InfoMessage;
import de.adv.rfsprojekt.websocket.entities.InfoPayload;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;
import de.adv.rfsprojekt.websocket.entities.rubiksSolver.RubiksSolverCommandPayload;
import de.adv.rfsprojekt.websocket.entities.rubiksSolver.ScanCompleteInfoPayload;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Consumer;


@ApplicationScoped
public class RubiksCommander {
    @Inject
    RubiksCalculator rubiksCalculator;
    @Inject
    RubiksSolver rubiksSolver;

    @Inject
    RubiksScanner rubiksScanner;

    private String cubeString;


    public void executeCommand(RubiksSolverCommandPayload commandPayload, Consumer<WebsocketMessage<InfoPayload<?>>> broadcast) throws Exception {
        switch (commandPayload.getCommandType()) {
            //ToDo Roboter Ficken
            case STOP -> {
                break;
            }
            case START_SCAN -> analyzeRubiksCube();
            case START_SOLVE -> solveCube(broadcast);
        }
    }

    public void analyzeRubiksCube() throws Exception {
        cubeString = rubiksScanner.scan();
        System.out.println(cubeString);
    }

    public void solveCube(Consumer<WebsocketMessage<InfoPayload<?>>> broadcast) throws Exception {
        //ToDo Lösungspfad berechnen und an Frontendschichen noch in Scan Phase machen
        String unsolvedCube = "UUUUUUFFFUBBRRRRRRRRRFFDFFDDDBDDBDDBFFDLLLLLLLLLUBBUBB";
        var moves = rubiksCalculator.calculateSolvingPath(unsolvedCube);
        var scriptMoves = rubiksCalculator.getScriptsForMoves(moves);
        var cubeStructure = new ScanCompleteInfo(unsolvedCube, moves);
        broadcast.accept(new InfoMessage<>(new ScanCompleteInfoPayload(cubeStructure)));
        rubiksSolver.solve(scriptMoves, moves, broadcast);
    }

}
