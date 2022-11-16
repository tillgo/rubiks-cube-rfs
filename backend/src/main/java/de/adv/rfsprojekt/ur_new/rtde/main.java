package de.adv.rfsprojekt.ur_new.rtde;

import de.adv.rfsprojekt.ur_new.rtde.entities.packages.data.DataType;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        RTDE rtde = new RTDE("192.168.2.40");
        rtde.connect();
        System.out.println(rtde.negotiateProtocolVersion());
        List<DataType> outputVariables = new ArrayList<>();
        outputVariables.add(DataType.ACTUAL_TCP_POSE);
        rtde.send_output_setup(outputVariables, 125);
        System.out.println(rtde.sendStart());

    }
}
