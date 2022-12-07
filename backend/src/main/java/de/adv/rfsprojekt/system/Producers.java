package de.adv.rfsprojekt.system;


import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.URImpl;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class Producers {


    @Produces
    UR initUR() throws IOException {
        return new URImpl(Config.getURHost(), Config.getURSecondaryPort());
    }
}
