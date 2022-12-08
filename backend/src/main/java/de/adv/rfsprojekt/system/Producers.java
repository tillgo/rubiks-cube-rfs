package de.adv.rfsprojekt.system;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import de.adv.rfsprojekt.ur_new.UR;
import de.adv.rfsprojekt.ur_new.URImpl;
import de.adv.rfsprojekt.websocket.entities.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.time.LocalDate;

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
