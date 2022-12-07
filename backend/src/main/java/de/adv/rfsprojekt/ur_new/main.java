package de.adv.rfsprojekt.ur_new;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        DashboardListener dashboardListener = new DashboardListener("192.168.2.108");
        dashboardListener.start();

    }
}
