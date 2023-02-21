package de.adv.rfsprojekt.ur.entities;

import java.io.InputStream;
import java.io.OutputStream;

public interface URConnection {

    OutputStream getOutputStream();

    InputStream getInputStream();

}
