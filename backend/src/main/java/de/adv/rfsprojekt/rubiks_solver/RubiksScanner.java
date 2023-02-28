package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.images.ImageService;
import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.util.CubeColor;
import de.adv.rfsprojekt.util.Face;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ApplicationScoped
public class RubiksScanner {

    @Inject
    UR ur;

    @Inject
    ImageService imageService;

    @Inject
    PoseChecker poseChecker;

    private final Map<Face, List<Integer>> positions = Map.of(
            Face.U, List.of(1,2,3,4,5,6,7,8,9),
            Face.R, List.of(7,4,1,8,5,2,9,6,3),
            Face.F, List.of(1,2,3,4,5,6,7,8,9),
            Face.D, List.of(1,2,3,4,5,6,7,8,9),
            Face.L, List.of(7,4,1,8,5,2,9,6,3),
            Face.B, List.of(9,8,7,6,5,4,3,2,1)
    );

    private final Map<Face, List<CubeColor>> colors = new HashMap<>();

    public String scan() throws Exception {
        var moves = RubiksSolvingScripts.SCAN_MOVES.entrySet();

        for (var move : moves) {
            ur.execute(move.getValue());
            poseChecker.waitTilReachedEndPosition(Config.SCANNER_POSE);

            colors.put(move.getKey(), imageService.getCurrentCubeColors());
        }

        return positions.entrySet()
                .stream()
                .flatMap(e -> {
                    var colorsFace = colors.get(e.getKey());
                    return e.getValue().stream().map(i -> colorsFace.get(i).getPosition());
                })
                .reduce("", (prev, curr) -> prev + curr);
    }

}
