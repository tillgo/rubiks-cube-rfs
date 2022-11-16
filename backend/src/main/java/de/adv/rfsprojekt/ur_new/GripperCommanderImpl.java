package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.URConnection;

import java.io.IOException;

import static de.adv.rfsprojekt.ur_new.urscript_commands.tools.robotiq_gripper.RobotIQGripperCommands.*;


/**
 * ToDo Prüfen, ob GripperCommands auch zusammen mit normalen URScript commands ausgeführt werden kann.
 * ACHTUNG: Preamble dürfte dann trotzdem nur einmal geschickt werden
 */
public class GripperCommanderImpl implements GripperCommander {

    private URScriptBuilder urScriptBuilder;

    public GripperCommanderImpl(URConnection urConnection) {
        urScriptBuilder = new URScriptBuilderImpl(urConnection);
    }

    @Override
    public void activate() throws IOException, InterruptedException {
        urScriptBuilder.customScript(ACTIVATE()).execute();
        System.out.println("Test");
        Thread.sleep(5000); //Muss wohl so siehe: https://sdurobotics.gitlab.io/ur_rtde/_static/robotiq_gripper_control.py
    }

    @Override
    public void open() throws IOException {
        urScriptBuilder.customScript(OPEN()).execute();
    }

    @Override
    public void close() throws IOException {
        urScriptBuilder.customScript(CLOSE()).execute();
    }

    @Override
    public void move(int posInMM) throws IOException {
        urScriptBuilder.customScript(MOVE(posInMM)).execute();
    }

}
