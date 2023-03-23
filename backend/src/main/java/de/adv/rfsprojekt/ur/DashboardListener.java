package de.adv.rfsprojekt.ur;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DashboardListener extends Thread {

    private final Socket socket;

    @ConfigProperty(name = "ur.dashboard_port")
    int dashboardPort;

    public DashboardListener(String host) throws IOException {
        socket = new Socket(host, 29999);
    }


    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(readResponse(socket.getInputStream()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    private String readResponse(InputStream is) throws IOException, InterruptedException {
        StringBuffer sb = new StringBuffer();
        char c;
        do {
            int currByte = is.read();
            if (currByte == -1) {
                Thread.sleep(10);
                continue;
            }
            c = (char) currByte;
            if (c == '\n')
                break;
            sb.append(c);
        } while (true);
        return sb.toString();
    }


}
