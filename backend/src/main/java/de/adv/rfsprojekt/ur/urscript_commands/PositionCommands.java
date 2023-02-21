package de.adv.rfsprojekt.ur.urscript_commands;

import de.adv.rfsprojekt.ur.entities.Pose;

public class PositionCommands {

    public static String GET_TOOL_POSE() {
        StringBuilder sb = new StringBuilder();
        sb.append("tool_pose");
        return sb.toString();
    }

    public static String GET_POSE_RELATIVE_TO_TOOL(String p) {
        return "pose_trans(get_forward_kin(), " + p + ")";
    }

    public static String GET_POSE_RELATIVE_TO_TOOL(Pose p) {
        return "pose_trans(get_forward_kin(), " + p + ")";
    }
}
