package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.rubiks_solver.models.Move;
import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScript;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RubiksSolver {

    @Inject
    UR ur;

    @Inject
    PoseChecker poseChecker;

    public void solve(List<URScript> scripts, List<Move> moves) throws Exception {
        for (int i = 0; i < scripts.size(); i++) {
            System.out.println("-----------------------------------------------------------");
            System.out.println(moves.get(i));
            ur.execute(scripts.get(i));
            poseChecker.waitTilReachedEndPosition(Config.GREIF_HOCH_POSE);
        }
    }
}
