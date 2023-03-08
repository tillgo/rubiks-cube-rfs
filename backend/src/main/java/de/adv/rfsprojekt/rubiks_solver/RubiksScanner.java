package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.images.ImageService;
import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.util.CubeColor;
import de.adv.rfsprojekt.util.Face;
import io.smallrye.mutiny.tuples.Tuple2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class RubiksScanner {

    @Inject
    UR ur;

    @Inject
    ImageService imageService;

    @Inject
    PoseChecker poseChecker;

    private final List<Tuple2<Face, List<Integer>>> positions = List.of(
            Tuple2.of(Face.U, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Tuple2.of(Face.R, List.of(7, 4, 1, 8, 5, 2, 9, 6, 3)),
            Tuple2.of(Face.F, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Tuple2.of(Face.D, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Tuple2.of(Face.L, List.of(7, 4, 1, 8, 5, 2, 9, 6, 3)),
            Tuple2.of(Face.B, List.of(9, 8, 7, 6, 5, 4, 3, 2, 1))
    );

    private final Map<Face, List<CubeColor>> colors = new HashMap<>();

    public String scan() throws Exception {
        RubiksSolvingScripts.SCAN_MOVES.forEach((move) -> {
                    try {
                        ur.execute(move.getItem2());
                        Thread.sleep(5000);
                        poseChecker.waitTilReachedEndPosition(Config.SCANNER_POSE);
                        //Thread.sleep(50000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
            var currCubeColors = imageService.getCurrentCubeColors();
                    currCubeColors.forEach(System.out::println);
                    colors.put(move.getItem1(), currCubeColors);
                }
        );


        return positions
                .stream()
                .flatMap(e -> {
                    System.out.println(e.getItem1());
                    var colorsFace = colors.get(e.getItem1());
                    return e.getItem2().stream().map(i -> colorsFace.get(i - 1).getPosition());
                })
                .reduce("", (prev, curr) -> prev + curr);
    }

}
