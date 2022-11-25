package de.adv.rfsprojekt.ur_new.rtde.entities.packages;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MessagePacket extends Package {
    private PackageType packageType;
    private MessageWarningLevel warningLevel;
    private String message;
    String source;

    public MessagePacket(PackageType packageType, MessageWarningLevel warningLevel, String message, String source) {
        super(packageType);
        this.warningLevel = warningLevel;
        this.message = message;
        this.source = source;
    }


    public static MessagePacket unpack(ByteBuffer payload) {
        int messageLength = payload.get();
        byte[] messageArray = new byte[messageLength];
        payload.get(messageArray, payload.position(), messageLength);
        payload.position(payload.position() + messageLength);
        String message = new String(messageArray, StandardCharsets.UTF_8);

        int sourceLength = payload.get();
        byte[] sourceArray = new byte[sourceLength];
        payload.get(sourceArray, payload.position(), messageLength);
        payload.position(payload.position() + messageLength);
        String source = new String(sourceArray, StandardCharsets.UTF_8);

        MessageWarningLevel wl = MessageWarningLevel.valueOfLabel(payload.get());

        return new MessagePacket(PackageType.RTDE_TEXT_MESSAGE, wl, message, source);
    }

    @Override
    public PackageType getPackageType() {
        return packageType;
    }

    public MessageWarningLevel getWarningLevel() {
        return warningLevel;
    }

    public String getPayload() {
        return message;
    }

    public String getSource() {
        return source;
    }
}
