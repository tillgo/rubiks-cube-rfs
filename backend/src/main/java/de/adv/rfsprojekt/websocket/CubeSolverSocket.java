package de.adv.rfsprojekt.websocket;

import com.google.gson.Gson;
import de.adv.rfsprojekt.rubiks_solver.RubiksCommander;
import de.adv.rfsprojekt.service.shared.ErrorAnalyzer;
import de.adv.rfsprojekt.websocket.entities.ErrorMessage;
import de.adv.rfsprojekt.websocket.entities.ErrorPayload;
import de.adv.rfsprojekt.websocket.entities.MessageType;
import de.adv.rfsprojekt.websocket.entities.WebsocketMessage;
import de.adv.rfsprojekt.websocket.entities.rubiksSolver.RubiksSolverCommand;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/cube-solver/{clientname}")
@ApplicationScoped
public class CubeSolverSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @Inject
    RubiksCommander rubiksCommander;

    private ErrorAnalyzer errorAnalyzer;

    @Inject
    Gson gson;

    @ConfigProperty(name = "ur.erroranalyzer.enabled")
    boolean analyzerEnabled;


    @OnOpen
    public void onOpen(Session session, @PathParam("clientname") String clientname) {
        if (sessions.size() == 0 && analyzerEnabled) {
            errorAnalyzer = new ErrorAnalyzer(this::broadcast);
            errorAnalyzer.start();
        }
        sessions.put(clientname, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("clientname") String clientname) {
        sessions.remove(clientname);
        if (sessions.size() == 0 && analyzerEnabled) {
            errorAnalyzer.kill();
            errorAnalyzer = null;
        }
    }

    @OnError
    public void onError(Session session, @PathParam("clientname") String clientname, Throwable throwable) {
        var errorMessage = new ErrorMessage(new ErrorPayload(throwable.getMessage()));
        throwable.printStackTrace();
        broadcast(errorMessage);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("clientname") String clientname) {
        var type = MessageType.valueOf(StringUtils.substringsBetween(message, "\"", "\"")[1]);
        var messageClass = switch (type) {
            case ERROR, INFO -> ErrorMessage.class;
            case COMMAND -> RubiksSolverCommand.class;
        };
        var m = gson.fromJson(message, messageClass);
        if (m instanceof RubiksSolverCommand command) {
            try {
                rubiksCommander.executeCommand(command.getPayload(), this::broadcast);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void broadcast(WebsocketMessage<?> message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(gson.toJson(message), result -> {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }

}
