package de.adv.rfsprojekt.rubiks_solver;

import de.adv.rfsprojekt.rubiks_solver.models.Move;
import de.adv.rfsprojekt.ur_new.entities.JointPose;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScript;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScriptBuilderImpl;

import static de.adv.rfsprojekt.system.Config.*;

public class RubiksSolvingScripts {

    private static final double ZSAFE = 0.4;

    private static final double RAD_90DEG = 1.571;

    private static final double RAD_180DEG = RAD_90DEG * 2;

    private static URScript SPIN(double wrist3rad) {
        return new URScriptBuilderImpl()
                .moveRelativeToTCP(new JointPose(0, 0, 0, 0, 0, wrist3rad))
                .getURScript();
    }

    private static URScript SPIN_CUBE(double wrist3rad) {
        return new URScriptBuilderImpl()
                .moveL(GREIF_HOCH_POSE)
                //  .openGripper()
                .moveL(GREIF_POSE)
                //  .closeGripper()
                .moveL(GREIF_HOCH_POSE)
                .addURScript(SPIN(wrist3rad))
                .moveL(GREIF_POSE)
                //  .openGripper()
                .addURScript(SPIN(wrist3rad * -1))
                .getURScript();
    }

    private static final URScript TURN_BACK_TO_TOP_WITHOUT_SAFETY =
            new URScriptBuilderImpl()
                    //        .openGripper()
                    .moveL(GREIF_POSE)
                    //        .closeGripper()
                    .moveL(GREIF_HOCH_POSE)
                    .moveL(DROP_HOCH_POSE)
                    .moveL(DROP_POSE)
                    //        .openGripper()
                    .moveL(DROP_HOCH_POSE)
                    .getURScript();

    private static URScript CREATE_MOVE_SCRIPT(URScript faceTurn, URScript spin, URScript spinBack) {
        return new URScriptBuilderImpl()
                .addURScript(faceTurn)
                .moveL(GREIF_HOCH_POSE)
                // .openGripper()
                .moveL(GREIF_POSE)
                // .closeGripper()
                .addURScript(spin)
                // .openGripper()
                .moveL(GREIF_HOCH_POSE)
                .addURScript(spinBack)
                .getURScript();
    }


    public final static URScript SPIN_CUBE_90DEG_CLOCK = SPIN_CUBE(-RAD_90DEG);
    public final static URScript SPIN_CUBE_90DEG_COUNTERCLOCK = SPIN_CUBE(RAD_90DEG);
    public final static URScript SPIN_CUBE_180DEG = SPIN_CUBE(RAD_180DEG);


    public final static URScript TURN_BACK_TO_TOP =
            new URScriptBuilderImpl()
                    .moveL(GREIF_HOCH_POSE)
                    .addURScript(TURN_BACK_TO_TOP_WITHOUT_SAFETY)
                    .getURScript();

    public static final URScript TURN_LEFT_TO_TOP =
            new URScriptBuilderImpl()
                    .addURScript(SPIN_CUBE_90DEG_CLOCK)
                    .addURScript(TURN_BACK_TO_TOP_WITHOUT_SAFETY)
                    .getURScript();

    public static final URScript TURN_RIGHT_TO_TOP =
            new URScriptBuilderImpl()
                    .addURScript(SPIN_CUBE_90DEG_COUNTERCLOCK)
                    .addURScript(TURN_BACK_TO_TOP_WITHOUT_SAFETY)
                    .getURScript();

    public static final URScript TURN_FRONT_TO_TOP =
            new URScriptBuilderImpl()
                    .addURScript(SPIN_CUBE_180DEG)
                    .addURScript(TURN_BACK_TO_TOP_WITHOUT_SAFETY)
                    .getURScript();

    public static final URScript TURN_BOTTOM_TO_TOP =
            new URScriptBuilderImpl()
                    .addURScript(TURN_BACK_TO_TOP)
                    .addURScript(TURN_BACK_TO_TOP)
                    .getURScript();

    public static final URScript TURN_UP_TO_TOP_OMEGALUL =
            new URScriptBuilderImpl()
                    .moveL(GREIF_HOCH_POSE)
                    .getURScript();


    public static URScript GET_SCRIPT_FOR_MOVE(Move move) {
        URScript spinScript = SPIN(-RAD_90DEG * move.getCount());
        URScript spingBackScript = SPIN(RAD_90DEG * move.getCount());

        URScript faceTurn = switch (move.getFace()) {
            case B -> TURN_BACK_TO_TOP;
            case U -> TURN_UP_TO_TOP_OMEGALUL;
            case R -> TURN_RIGHT_TO_TOP;
            case L -> TURN_LEFT_TO_TOP;
            case F -> TURN_FRONT_TO_TOP;
            case D -> TURN_BOTTOM_TO_TOP;
        };

        return CREATE_MOVE_SCRIPT(faceTurn, spinScript, spingBackScript);
    }


}

