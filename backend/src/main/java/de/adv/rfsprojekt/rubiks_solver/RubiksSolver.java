package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.rubiks_solver.models.CubeUpdate;
import de.adv.rfsprojekt.rubiks_solver.models.Move;
import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import de.adv.rfsprojekt.websocket.entities.InfoMessage;
import de.adv.rfsprojekt.websocket.entities.InfoPayload;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;
import de.adv.rfsprojekt.websocket.entities.rubiksSolver.CubeUpdateInfoPayload;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Consumer;

@ApplicationScoped
public class RubiksSolver {

    @Inject
    UR ur;

    @Inject
    PoseChecker poseChecker;

    public void solve(List<URScript> scripts, List<Move> moves, Consumer<WebsocketMessage<InfoPayload<?>>> broadcast) throws Exception {
        for (int i = 0; i < scripts.size(); i++) {
            var cubeUpdate = new CubeUpdate(i + 1, moves.size(), moves.get(i));
            System.out.println("---------------------------------------------------------------");
            broadcast.accept(new InfoMessage<>(new CubeUpdateInfoPayload(cubeUpdate)));
            ur.execute(scripts.get(i));
            poseChecker.waitTilReachedEndPosition(Config.GREIF_HOCH_POSE);
        }
    }
}
