package de.adv.rfsprojekt.system;

import org.eclipse.microprofile.config.ConfigProvider;

public class Config {

    public static double getMoveSpeedArm(){
       return ConfigProvider.getConfig().getValue("ur.move.speed.arm", Double.class);
    }

    public static double getMoveSpeedTool(){
        return ConfigProvider.getConfig().getValue("ur.move.speed.tool", Double.class);
    }

    public static double getMoveTime(){
        return ConfigProvider.getConfig().getValue("ur.move.time", Double.class);
    }

    public static String getURHost(){
        return ConfigProvider.getConfig().getValue("ur.hostname", String.class);
    }

    public static int getURSecondaryPort(){
        return ConfigProvider.getConfig().getValue("ur.secondary_port", Integer.class);
    }

    public static int getURRTDEPort(){
        return ConfigProvider.getConfig().getValue("ur.rtde_port", Integer.class);
    }
}
