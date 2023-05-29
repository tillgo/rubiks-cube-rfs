package de.adv.rfsprojekt.ur.rtde.entities.packages;

public abstract class Package {
    private PackageType packageType;

    public Package(PackageType packageType) {
        this.packageType = packageType;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public abstract Object getPayload();
}
