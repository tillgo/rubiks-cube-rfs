package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.URConnection;
import de.adv.rfsprojekt.ur_new.urscript_builder.URScript;

import java.io.IOException;

public interface UR {

    void powerOn() throws IOException, InterruptedException;

    void powerOff() throws IOException;

    void execute(URScript script) throws IOException;


    String executeWithMessage(URScript script) throws IOException, InterruptedException;

    String getHost();

    int getPort();

    URConnection getURConnection();

}
