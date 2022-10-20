package de.adv.rfsprojekt.ur_new.urscript_commands;



import de.adv.rfsprojekt.ur_new.entities.Pose;

public class MovementCommands {

    public static String MOVE_L(String p, double a, double v, double t, double r){
        return "movel(" +
                p + ',' +
                "a=" + a + ',' +
                "v=" + v + ',' +
                "t=" + t + ',' +
                "r=" + r +
                ")\n";


        }
}
