package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.Pose;

import java.io.IOException;


public interface URScriptBuilder {

    URScriptBuilder moveRelativeToTCP(Pose p);

    URScriptBuilder speedL(Pose p);

    void execute() throws IOException;

    String executeWithMessage() throws IOException, InterruptedException;

}
