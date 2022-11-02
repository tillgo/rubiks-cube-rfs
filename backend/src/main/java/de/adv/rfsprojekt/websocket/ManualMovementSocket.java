package de.adv.rfsprojekt.websocket;

import de.adv.rfsprojekt.service.manualMovement.ManualMovementController;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ToDO Clientname kann redundant sein, eventuell ändern
 **/
@ServerEndpoint("/manual/{clientname}")
@ApplicationScoped
public class ManualMovementSocket {
    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @Inject
    ManualMovementController mmC;

    @OnOpen
    public void onOpen(Session session, @PathParam("clientname") String clientname) {
        sessions.put(clientname, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("clientname") String clientname) {
        sessions.remove(clientname);
    }

    /**
     * @OnError public void onError(Session session, @PathParam("clientname") String clientname){
     * sessions.remove(clientname);
     * }
     **/


    @OnMessage
    public void onMessage(String message, @PathParam("clientname") String clientname) {
        try {
            System.out.println(message);
            mmC.executeMove(message);
        } catch (IOException e) {
            sessions.get(clientname).getAsyncRemote().sendText("Upsi Fehler");
        }

        /*System.out.println(message);*/

    }

    private void broadcast(String message) {

    }


}
