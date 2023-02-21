package de.adv.rfsprojekt.ur.urscript_commands;


import de.adv.rfsprojekt.ur.entities.JointPose;
import de.adv.rfsprojekt.ur.entities.Pose;

public class MovementCommands {

    public static String MOVE_L(Pose p, double a, double v, double t, double r) {
        return MOVE_L(p.toString(), a, v, t, r);
    }

    public static String MOVE_L(String p, double a, double v, double t, double r) {
        return "movel(" +
                p + ',' +
                "a=" + a + ',' +
                "v=" + v + ',' +
                "t=" + t + ',' +
                "r=" + r +
                ")";
    }

    public static String MOVE_J(Pose p, double a, double v, double t, double r) {
        return MOVE_J(p.toString(), a, v, t, r);
    }

    public static String MOVE_J(String p, double a, double v, double t, double r) {
        return "movej(" +
                p + ',' +
                "a=" + a + ',' +
                "v=" + v + ',' +
                "t=" + t + ',' +
                "r=" + r +
                ")";
    }

    public static String MOVE_RELATIVE_TO_TOOL(JointPose joints, double a, double v, double t, double r) {
        return "jp = get_actual_joint_positions()\n" +
                "movej([jp[0]+(" + joints.base() + "),jp[1]+(" + joints.shoulder() + "),jp[2]+(" + joints.elbow() +
                "),jp[3]+(" + joints.wrist1() + "),jp[4]+(" + joints.wrist2() + "),jp[5]+(" + joints.wrist3() + ")]," +
                "a=" + a + ',' +
                "v=" + v + ',' +
                "t=" + t + ',' +
                "r=" + r +
                ")";
    }

    public static String MOVEL_Z_AXIS(double z) {
        return "curr_pos = get_actual_tcp_pose()\n" +
                "curr_pos[2] = + " + z + "\n" +
                MOVE_L("curr_pos", 1, 0.2, 0, 0);

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
                ")";
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
                ")";
    }

}
