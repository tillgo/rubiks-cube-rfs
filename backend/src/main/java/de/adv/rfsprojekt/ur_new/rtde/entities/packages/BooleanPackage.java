package de.adv.rfsprojekt.ur_new.rtde.entities.packages;

import java.nio.ByteBuffer;

public class BooleanPackage extends Package {

    private boolean success;

    public BooleanPackage(PackageType packageType, boolean success) {
        super(packageType);
        this.success = success;
    }

    public static BooleanPackage unpack(ByteBuffer payload) {
        return new BooleanPackage(PackageType.RTDE_REQUEST_PROTOCOL_VERSION, (int) payload.get() == 1);
    }

    public Boolean getPayload() {
        return success;
    }


}