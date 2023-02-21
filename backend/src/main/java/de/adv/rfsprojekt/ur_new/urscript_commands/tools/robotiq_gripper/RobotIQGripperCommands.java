package de.adv.rfsprojekt.ur_new.urscript_commands.tools.robotiq_gripper;

/**
 * Ehrenhaft abgeschaut von https://sdurobotics.gitlab.io/ur_rtde/_static/robotiq_gripper_control.py
 */
public class RobotIQGripperCommands {

    public static String ACTIVATE() {
        return "rq_activate()";
    }

    public static String OPEN() {
        return "rq_open_and_wait()";
    }

    public static String CLOSE() {
        return "rq_close_and_wait()";
    }

    public static String MOVE(int posInMM) {
        return "rq_move_and_wait_mm(" + posInMM + ")";
    }
}
