package de.adv.rfsprojekt.ur.rtde.entities.exceptions;

public class URPackageNotFoundException extends URException {
    public URPackageNotFoundException() {
        super("Package not Found");
    }
}
