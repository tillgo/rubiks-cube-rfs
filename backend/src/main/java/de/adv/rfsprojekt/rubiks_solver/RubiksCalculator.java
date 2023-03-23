package de.adv.rfsprojekt.rubiks_solver;


import de.adv.rfsprojekt.rubiks_solver.min2phase.Search;
import de.adv.rfsprojekt.rubiks_solver.models.Move;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import de.adv.rfsprojekt.util.Face;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class RubiksCalculator {

    //Map<AktuelleFace, Map<VorherigeFace, NeueFace>>
    Map<Face, Map<Face, Face>> map = Map.of(
            Face.U, Map.of(
                    Face.U, Face.U,
                    Face.F, Face.F,
                    Face.L, Face.F,
                    Face.R, Face.F,
                    Face.B, Face.F,
                    Face.D, Face.D
            ),
            Face.F, Map.of(
                    Face.U, Face.F,
                    Face.F, Face.U,
                    Face.L, Face.L,
                    Face.R, Face.R,
                    Face.B, Face.D,
                    Face.D, Face.B
            ),
            Face.L, Map.of(
                    Face.U, Face.L,
                    Face.F, Face.R,
                    Face.L, Face.U,
                    Face.R, Face.D,
                    Face.B, Face.L,
                    Face.D, Face.L
            ),
            Face.R, Map.of(
                    Face.U, Face.R,
                    Face.F, Face.L,
                    Face.L, Face.D,
                    Face.R, Face.U,
                    Face.B, Face.R,
                    Face.D, Face.R
            ),
            Face.B, Map.of(
                    Face.U, Face.B,
                    Face.F, Face.D,
                    Face.L, Face.R,
                    Face.R, Face.L,
                    Face.B, Face.U,
                    Face.D, Face.F
            ),
            Face.D, Map.of(
                    Face.U, Face.D,
                    Face.F, Face.B,
                    Face.L, Face.B,
                    Face.R, Face.B,
                    Face.B, Face.B,
                    Face.D, Face.U
            )

    );

    public List<Move> calculateSolvingPath(String unsolvedCube) {

        var solvedCube = new Search()
                .solution(unsolvedCube, 21, 10000000, 50000, 0);


        var moveStrings = Arrays.stream(solvedCube.split(" "))
                .map(move -> move.split(""))
                .filter(moveString -> !moveString[0].isBlank())
                .toList();

        var moves = new ArrayList<Move>();
        for (int i = 0; i < moveStrings.size(); i++) {
            String[] moveString = moveStrings.get(i);
            String turnOrder = moveString.length >= 2 ? moveString[1] : null;
            moves.add(new Move(Face.valueOf(moveString[0]), turnOrder));
            for (int j = i + 1; j < moveStrings.size(); j++) {
                String[] followingMoveString = moveStrings.get(j);
                followingMoveString[0] = map.get(Face.valueOf(followingMoveString[0])).get(Face.valueOf(moveString[0])).toString();
            }
        }
        return moves;
    }

    public List<URScript> getScriptsForMoves(List<Move> moves) {
        return moves.stream().map(RubiksSolvingScripts::GET_SCRIPT_FOR_MOVE).toList();
    }

    public static void main(String[] args) {
        String unsolvedCube = "URBLURRLRUFDBRBBULDUBLFRBFLDUUDDBFBDRFFDLDURRLUFLBFFDL";
        System.out.println(new Search().solution(unsolvedCube, 21, 10000000, 50000, 0));
        var test = new RubiksCalculator().calculateSolvingPath(unsolvedCube);
        System.out.println(test.size());
        System.out.println(test);

    }
}
