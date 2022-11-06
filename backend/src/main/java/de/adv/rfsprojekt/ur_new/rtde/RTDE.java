package de.adv.rfsprojekt.ur_new.rtde;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;


/**
 * Geht aktuell nur mit Protokol Version 2
 */
public class RTDE {

    public final static int RTDE_PROTOCOL_VERSION_2 = 2;

    private final String hostname;

    private Socket socket = null;
    private OutputStream os = null;
    private InputStream is = null;

    private ByteBuffer buffer = null;


    public RTDE(String hostname) {
        this.hostname = hostname;
    }

    public void connect() throws IOException {
        if (socket != null) {
            return;
        }
        try {
            socket = new Socket(hostname, 30004);
            os = socket.getOutputStream();
            is = socket.getInputStream();
        } catch (IOException e) {
            socket = null;
            os = null;
            is = null;
            throw e;
        }
    }


    private void recvToBuffer() throws Exception {
        byte[] message = is.readAllBytes();

        if (message.length == 0) {
            /*ToDo Spezifische Exception werfen und disconnecten*/
            throw new Exception();
        }
        buffer = ByteBuffer.wrap(message);
    }


}
