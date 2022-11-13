package de.adv.rfsprojekt.ur_new.rtde.entities;

import java.nio.ByteBuffer;

public class PacketHeader {

    private final int packetSize;
    private final int packetTyp;

    public PacketHeader(int packetSize, int packetTyp) {
        this.packetSize = packetSize;
        this.packetTyp = packetTyp;
    }

    public static PacketHeader fromByteBuffer(ByteBuffer buffer) {
        return new PacketHeader(buffer.getShort(), buffer.get());
    }

    public int getPacketSize() {
        return packetSize;
    }

    public int getPacketTyp() {
        return packetTyp;
    }
}
