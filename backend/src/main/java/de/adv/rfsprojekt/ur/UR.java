package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.URConnection;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;

import java.io.IOException;

public interface UR {

    void powerOn() throws IOException, InterruptedException;

    void powerOff() throws IOException;

    void execute(URScript script) throws IOException;


    String getHost();

    int getSecondaryPort();

    URConnection getURConnection();

}
