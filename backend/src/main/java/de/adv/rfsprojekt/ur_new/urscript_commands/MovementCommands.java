package de.adv.rfsprojekt.ur_new.urscript_commands;


import de.adv.rfsprojekt.ur_new.entities.Pose;

public class MovementCommands {

    public static String MOVE_L(Pose p, double a, double v, double t, double r){
        return MOVE_L(p.toString(), a, v, t, r);
    }

    public static String MOVE_L(String p, double a, double v, double t, double r) {
        return "movel(" +
                p + ',' +
                "a=" + a + ',' +
                "v=" + v + ',' +
                "t=" + t + ',' +
                "r=" + r +
                ")\n";


    }

    /**
     * Tool speed
     * Accelerate linearly in Cartesian space and continue with constant tool
     * speed. The time t is optional; if provided the function will return after
     * time t, regardless of the target speed has been reached. If the time t is
     * not provided, the function will return when the target speed is reached.
     *
     * @param p String with tool speed [m/s] (spatial vector)
     * @param a tool position acceleration [m/s^2]
     * @param t time [s] before function returns (optional)
     * @return
     */
    public static String SPEED_L(String p, double a, double t) {
        return "speedl(" +
                p + "," +
                "a=" + a + "," +
                "t=" + t +
                ")\n";
    }

    /**
     * Tool speed
     * Accelerate linearly in Cartesian space and continue with constant tool
     * speed. The time t is optional; if provided the function will return after
     * time t, regardless of the target speed has been reached. If the time t is
     * not provided, the function will return when the target speed is reached.
     *
     * @param p    String with tool speed [m/s] (spatial vector)
     * @param a    tool position acceleration [m/s^2]
     * @param t    time [s] before function returns (optional)
     * @param aRot tool acceleration [rad/s^2] (optional), if not defined
     *             a, position acceleration, is used
     * @return
     */
    public static String SPEED_L(String p, double a, double t, double aRot) {
        return "speedl(" +
                p + "," +
                "a=" + a + "," +
                "t=" + t +
                "aRot=" + aRot + "," +
                ")\n";
    }
}
