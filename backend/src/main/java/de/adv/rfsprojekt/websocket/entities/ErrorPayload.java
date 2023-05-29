package de.adv.rfsprojekt.websocket.entities;

public class ErrorPayload implements BasePayload{

    private final String message;

    public ErrorPayload(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorPayload{" +
                "message='" + message + '\'' +
                '}';
    }
}
