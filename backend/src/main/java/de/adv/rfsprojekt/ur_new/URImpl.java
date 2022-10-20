package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.URConnection;
import de.adv.rfsprojekt.ur_new.setup.URPorts;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import static java.nio.charset.StandardCharsets.UTF_8;
import static de.adv.rfsprojekt.ur_new.urscript_commands.SetupCommands.*;

public class URImpl implements UR {

    final private String host;
    final private int port;

    final private URConnection urConnection;


    public URImpl(String host, int port) throws IOException {

        this.host = host;
        this.port = port;

        Socket socket = new Socket(host, port);
        urConnection = new URConnectionImpl(socket.getInputStream(), socket.getOutputStream());

    }

    /**
     * ToDo Bei Sicherheitsstopp muss Roboter wieder entriegelt werden. Wird in alter Lib in powerOn Methode geregelt
     */
    public void powerOn() throws IOException, InterruptedException {
        try(Socket dashSocket = new Socket(host, URPorts.DASHBOARD);){
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
        try(Socket dashSocket = new Socket(host, URPorts.DASHBOARD);){
            OutputStream os = dashSocket.getOutputStream();
            os.write(POWER_OFF().getBytes(UTF_8));
            os.flush();
        }
    }

    public URScriptBuilder buildScript(){
        return new URScriptBuilderImpl(urConnection, host);
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
    public URConnection getURConnection(){
        return urConnection;
    }




}
