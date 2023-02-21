package de.adv.rfsprojekt.ur;

import de.adv.rfsprojekt.ur.entities.URConnection;
import de.adv.rfsprojekt.ur.urscript_builder.URScript;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static de.adv.rfsprojekt.ur.urscript_commands.SetupCommands.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class URImpl implements UR {

    private final String host;
    private final int port;

    private final URConnection urConnection;

    @ConfigProperty(name = "ur.dashboard_port")
    int dashboardPort;


    public URImpl(String host, int port, boolean enabled) throws IOException {

        this.host = host;
        this.port = port;

        if (enabled) {
            Socket socket = new Socket(host, port);
            urConnection = new URConnectionImpl(socket.getInputStream(), socket.getOutputStream());
        } else {
            urConnection = null;
        }
    }

    /**
     * ToDo Bei Sicherheitsstopp muss Roboter wieder entriegelt werden. Wird in alter Lib in powerOn Methode geregelt
     */
    public void powerOn() throws IOException, InterruptedException {
        try (Socket dashSocket = new Socket(host, dashboardPort);) {
            OutputStream os = dashSocket.getOutputStream();
            InputStream is = dashSocket.getInputStream();
            String message;

            os.write(POWER_ON().getBytes(UTF_8));
            os.flush();
            Thread.sleep(50);


            os.write(BRAKE_RELEASE().getBytes(UTF_8));
            os.flush();
            Thread.sleep(50);
        }

    }


    public void powerOff() throws IOException {
        try (Socket dashSocket = new Socket(host, dashboardPort);) {
            OutputStream os = dashSocket.getOutputStream();
            os.write(POWER_OFF().getBytes(UTF_8));
            os.flush();
        }
    }


    @Override
    public void execute(URScript script) throws IOException {
        String scriptString = script.createProgramm();
        byte[] scriptData = scriptString.getBytes(UTF_8);
        System.out.println(scriptString);
        OutputStream os = urConnection.getOutputStream();
        os.write(scriptData);
        os.flush();
    }

    @Override
    public String executeWithMessage(URScript script) throws IOException, InterruptedException {
        execute(script);
        Thread.sleep(50);
        return readResponse(urConnection.getInputStream());
    }


    /*ToDo Funktioniert noch nicht korrekt, möglichkeit finden bytes mit der richtigen Kodierung (UTF-8) in String umzuwandeln*/
    private String readResponse(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        char c;
        do {
            c = (char) is.read();
            if (c == '\n')
                break;
            sb.append(c);
        } while (c != -1);
        return sb.toString();
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public URConnection getURConnection() {
        return urConnection;
    }


}
