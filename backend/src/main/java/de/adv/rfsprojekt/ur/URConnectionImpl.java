package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.URConnection;

import java.io.InputStream;
import java.io.OutputStream;

public class URConnectionImpl implements URConnection {

    private InputStream is;
    private OutputStream os;

    public URConnectionImpl(InputStream is, OutputStream os) {
        this.is = is;
        this.os = os;
    }

    public InputStream getInputStream() {
        return is;
    }

    public OutputStream getOutputStream() {
        return os;
    }
}
