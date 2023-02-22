package de.adv.rfsprojekt.websocket.entities;

public abstract class InfoPayload<T> implements BasePayload {

    private final InfoMessageType infoType;

    private final T data;

    public InfoPayload(InfoMessageType infoType, T data) {
        this.infoType = infoType;
        this.data = data;
    }

    public InfoMessageType getInfoType() {
        return infoType;
    }

    public T getData() {
        return data;
    }
}
