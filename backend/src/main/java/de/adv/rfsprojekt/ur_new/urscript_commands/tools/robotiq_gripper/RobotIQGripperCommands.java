package de.adv.rfsprojekt.ur_new.urscript_commands.tools.robotiq_gripper;

import static de.adv.rfsprojekt.ur_new.urscript_commands.tools.robotiq_gripper.RobotIQGripperPreamble.getPreamble;

/**
 * Ehrenhaft abgeschaut von https://sdurobotics.gitlab.io/ur_rtde/_static/robotiq_gripper_control.py
 */
public class RobotIQGripperCommands {

    public static String ACTIVATE() {
        return getPreamble("rq_activate()");
    }

    public static String OPEN() {
        return getPreamble("rq_open_and_wait()");
    }

    public static String CLOSE() {
        return getPreamble("rq_close_and_wait()");
    }

    public static String MOVE(int posInMM) {
        return getPreamble("rq_move_and_wait_mm(" + posInMM + ")");
    }
}
