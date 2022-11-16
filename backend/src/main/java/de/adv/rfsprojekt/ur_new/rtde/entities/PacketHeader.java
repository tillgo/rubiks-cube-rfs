package de.adv.rfsprojekt.ur_new.rtde.entities;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.PackageType;

import java.nio.ByteBuffer;

public record PacketHeader(int packetSize, PackageType packageType) {

    /**
     * @param buffer          Buffer to get PackageHeader from
     * @param resetByteBuffer set Marker of PacketHeader back to beginning of extracted PackageHeader
     * @return PackageHeader
     */
    public static PacketHeader fromByteBuffer(ByteBuffer buffer, boolean resetByteBuffer) {
        PacketHeader ph = new PacketHeader(buffer.getShort(), PackageType.valueOfLabel(buffer.get()));
        if (resetByteBuffer) {
            buffer.position(buffer.position() - 3);
        }
        return ph;
    }


}
