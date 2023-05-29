package de.adv.rfsprojekt.system;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.enterprise.inject.Produces;

public class Producers {
    

    @Produces
    public Gson createGson() {
        return new GsonBuilder()
                .create();
    }

}
