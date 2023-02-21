package de.adv.rfsprojekt.ur.urscript_builder;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur.entities.JointPose;
import de.adv.rfsprojekt.ur.entities.Pose;

import static de.adv.rfsprojekt.ur.urscript_commands.MovementCommands.*;
import static de.adv.rfsprojekt.ur.urscript_commands.PositionCommands.GET_POSE_RELATIVE_TO_TOOL;
import static de.adv.rfsprojekt.ur.urscript_commands.tools.robotiq_gripper.RobotIQGripperCommands.*;

public class URScriptBuilderImpl implements URScriptBuilder {
    private final URScript urScript;


    public URScriptBuilderImpl() {
        urScript = new URScriptImpl();
    }

    /*Movement*/

    @Override
    public URScriptBuilder moveL(Pose pose) {
        urScript.addCommand(MOVE_L(pose, 1, 0.2, 0, 0));
        return this;
    }

    @Override
    public URScriptBuilder moveJ(Pose pose) {
        urScript.addCommand(MOVE_J(pose, 1, 0.2, 0, 0));
        return this;
    }

    @Override
    public URScriptBuilder moveRelativeToTCP(Pose pose) {
        urScript.addCommand(MOVE_L(GET_POSE_RELATIVE_TO_TOOL(
                pose), 1, 0.2, 0, 0));

        return this;
    }

    @Override
    public URScriptBuilder moveRelativeToTCP(JointPose joints) {
        urScript.addCommand(MOVE_RELATIVE_TO_TOOL(joints, 1, 0.2, 0, 0));

        return this;
    }

    @Override
    public URScriptBuilder speedL(Pose toolspeeds) {
        urScript.addCommand(SPEED_L(toolspeeds.toStringArray(), 1, Config.getMoveTime()));
        return this;
    }

    @Override
    public URScriptBuilder moveLZAxis(double z) {
        urScript.addCommand(MOVEL_Z_AXIS(z));
        return this;
    }

    //Gripper
    @Override
    public URScriptBuilder activateGripper() {
        urScript.addCommand(ACTIVATE());
        urScript.includesGripperCommand(true);
        return this;
    }

    @Override
    public URScriptBuilder openGripper() {
        urScript.addCommand(OPEN());
        urScript.includesGripperCommand(true);
        return this;
    }

    @Override
    public URScriptBuilder closeGripper() {
        urScript.addCommand(CLOSE());
        urScript.includesGripperCommand(true);
        return this;
    }

    @Override
    public URScriptBuilder moveGripper(int posInMM) {
        urScript.addCommand(MOVE(posInMM));
        urScript.includesGripperCommand(true);
        return this;
    }

    //Custom

    @Override
    public URScriptBuilder customScript(String customScript) {
        urScript.addCommand(customScript + "\n");
        return this;
    }

    @Override
    public URScriptBuilder addURScript(URScript script) {
        urScript.addURScript(script);
        return this;
    }

    @Override
    public URScript getURScript() {
        return urScript;
    }

}
