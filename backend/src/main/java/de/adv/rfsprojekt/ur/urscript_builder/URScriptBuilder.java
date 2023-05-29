package de.adv.rfsprojekt.ur.urscript_builder;

import de.adv.rfsprojekt.ur.entities.JointPose;
import de.adv.rfsprojekt.ur.entities.Pose;

public interface URScriptBuilder {

    //Movement

    URScriptBuilder moveL(Pose pose);

    URScriptBuilder moveJ(Pose pose);

    URScriptBuilder moveRelativeToTCP(Pose pose);

    URScriptBuilder moveRelativeToTCP(JointPose joints);

    URScriptBuilder speedL(Pose toolspeeds);

    URScriptBuilder moveLZAxis(double z);


    //Gripper
    URScriptBuilder activateGripper();

    URScriptBuilder openGripper();

    URScriptBuilder closeGripper();

    URScriptBuilder moveGripper(int posInMM);

    // Custom
    URScriptBuilder customScript(String customScript);

    URScriptBuilder addURScript(URScript script);


    URScript getURScript();
}
