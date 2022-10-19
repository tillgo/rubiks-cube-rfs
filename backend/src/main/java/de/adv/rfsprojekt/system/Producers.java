package de.adv.rfsprojekt.system;

import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.URImpl;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Produces;

public class Producers {

    @ConfigProperty(name = "ur.hostname")
    String urHostname;

    @ConfigProperty(name = "ur.port")
    int urPort;

    @Produces
    UR initUR() {
        return new URImpl(urHostname, urPort);
    }
}
