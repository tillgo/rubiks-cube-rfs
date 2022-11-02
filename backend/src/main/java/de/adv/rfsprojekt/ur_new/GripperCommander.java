package de.adv.rfsprojekt.ur_new;

import java.io.IOException;

public interface GripperCommander {

    void activate() throws IOException, InterruptedException;

    void open() throws IOException;

    void close() throws IOException;

    void move(int posInMM) throws IOException;
}
