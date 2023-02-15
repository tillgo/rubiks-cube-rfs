package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.JointPose;
import de.adv.rfsprojekt.ur_new.entities.Pose;

import java.io.IOException;


public interface URScriptBuilder {

    URScriptBuilder moveL(Pose p);

    URScriptBuilder moveRelativeToTCP(Pose p);

    URScriptBuilder moveRelativeToTCP(JointPose joints);

    URScriptBuilder speedL(Pose p);

    URScriptBuilder customScript(String customScript);

    void execute() throws IOException;


    String executeWithMessage() throws IOException, InterruptedException;

}
