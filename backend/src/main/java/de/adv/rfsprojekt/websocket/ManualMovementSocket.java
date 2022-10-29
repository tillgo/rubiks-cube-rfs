package de.adv.rfsprojekt.websocket;

import com.google.gson.Gson;
import de.adv.rfsprojekt.service.manualMovement.ManualMovementController;
import de.adv.rfsprojekt.service.manualMovement.models.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
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

    /**@OnError public void onError(Session session, @PathParam("clientname") String clientname){
    sessions.remove(clientname);
    }
     **/

    /**
     * Je nach Befehlstyp wird anderer Objekttyp aus JSON erzeugt
     * ToDo Error-Message zurückgeben, falls Gson Error wirft
     **/
    @OnMessage
    public void onMessage(String message, @PathParam("clientname") String clientname) {
        Gson gson = new Gson();
        RoboMove roboMove = gson.fromJson(message, RoboMove.class);
        MoveType moveType = roboMove.getMoveType();

        switch (moveType) {
            case ROBO_ARM -> mmC.excecuteMove(gson.fromJson(message, RoboArmMove.class));
            case ROBO_TOOL -> mmC.excecuteMove(gson.fromJson(message, RoboToolMove.class));
            case GRIPPER -> mmC.excecuteMove(gson.fromJson(message, GripperMove.class));
        }
    }

    private void broadcast(String message) {

    }


}
