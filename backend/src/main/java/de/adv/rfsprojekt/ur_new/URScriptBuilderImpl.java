package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.system.Config;
import de.adv.rfsprojekt.ur_new.entities.JointPose;
import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.entities.URConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static de.adv.rfsprojekt.ur_new.urscript_commands.CommandUtils.COMBINE_COMMANDS_TO_PROGRAMM;
import static de.adv.rfsprojekt.ur_new.urscript_commands.MovementCommands.*;
import static de.adv.rfsprojekt.ur_new.urscript_commands.PositionCommands.GET_POSE_RELATIVE_TO_TOOL;
import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * ToDo Speed and Accelaration as Env-Variables
 */
public class URScriptBuilderImpl implements URScriptBuilder {

    StringBuilder sb;
    private URConnection urConnection;


    public URScriptBuilderImpl(URConnection urConnection) {
        sb = new StringBuilder();
        this.urConnection = urConnection;
    }


    /*Movement*/

    public URScriptBuilder moveL(Pose pose) {
        sb.append(MOVE_L(pose, 1, 0.2, 0, 0));
        return this;
    }

    public URScriptBuilder moveRelativeToTCP(Pose pose) {
        sb.append(MOVE_L(GET_POSE_RELATIVE_TO_TOOL(
                pose), 1, 0.2, 0, 0));

        return this;
    }

    public URScriptBuilder moveRelativeToTCP(JointPose joints) {
        sb.append(MOVE_RELATIVE_TO_TOOL(joints, 1, 0.2, 0, 0));

        return this;
    }


    public URScriptBuilder speedL(Pose toolspeeds) {
        sb.append(SPEED_L(toolspeeds.toStringArray(), 1, Config.getMoveTime()));
        return this;
    }

    public URScriptBuilder customScript(String customScript) {
        sb.append(customScript + "\n");
        return this;
    }


    public void execute() throws IOException {
        String script = COMBINE_COMMANDS_TO_PROGRAMM(sb.toString());
        byte[] scriptData = script.getBytes(UTF_8);
        System.out.println(script);
        OutputStream os = urConnection.getOutputStream();
        os.write(scriptData);
        os.flush();
        sb = new StringBuilder();
    }

    public String executeWithMessage() throws IOException, InterruptedException {
        execute();
        Thread.sleep(50);
        return readResponse(urConnection.getInputStream());
    }


    /*ToDo Funktioniert noch nicht korrekt, möglichkeit finden bytes mit der richtigen Kodierung (UTF-8) in String umzuwandeln*/
    private String readResponse(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        char c;
        do {
            c = (char) is.read();
            if (c == '\n')
                break;
            sb.append(c);
        } while (c != -1);
        return sb.toString();
    }
}
