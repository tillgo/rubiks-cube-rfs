package de.adv.rfsprojekt.system;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.adv.rfsprojekt.ur.UR;
import de.adv.rfsprojekt.ur.URImpl;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class Producers {

    @ConfigProperty(name = "ur.enabled", defaultValue = "true")
    boolean enabled;

    @Produces
    UR initUR() throws IOException {
        return new URImpl(Config.getURHost(), Config.getURSecondaryPort(), enabled);
    }

    @Produces
    public Gson createGson() {
        return new GsonBuilder()
                .create();
    }

}
