package de.adv.rfsprojekt.ur_new;

import de.adv.rfsprojekt.ur_new.entities.Pose;
import de.adv.rfsprojekt.ur_new.entities.URConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static de.adv.rfsprojekt.ur_new.urscript_commands.PositionCommands.*;
import static de.adv.rfsprojekt.ur_new.urscript_commands.MovementCommands.*;

public class URScriptBuilderImpl implements URScriptBuilder {

    private StringBuilder sbScript;
    private URConnection urConnection;
    private String host;

    public URScriptBuilderImpl(URConnection urConnection, String host) {
        sbScript = new StringBuilder();
        this.urConnection = urConnection;
        this.host = host;
    }


    /*Movement*/

    public URScriptBuilder moveRelativeToTCP(Pose pose){
        sbScript.append(MOVE_L(GET_POSE_RELATIVE_TO_TOOL(
                pose), 1f, 0.2f, 0, 0));

        return this;
    }


    public void execute() throws IOException {
        String script = sbScript.toString();
        byte[] scriptData = script.getBytes(UTF_8);
        OutputStream os = urConnection.getOutputStream();
        os.write(scriptData);
        os.flush();
        sbScript = new StringBuilder();
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
