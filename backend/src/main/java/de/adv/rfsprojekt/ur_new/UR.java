package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.URConnection;

import java.io.IOException;

public interface UR {

    void powerOn() throws IOException, InterruptedException;

    void powerOff() throws IOException;

    URScriptBuilder buildScript();

    GripperCommander commandGripper();

    String getHost();

    int getPort();

    URConnection getURConnection();

}
