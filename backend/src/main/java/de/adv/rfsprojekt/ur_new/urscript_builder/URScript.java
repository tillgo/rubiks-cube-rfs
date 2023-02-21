package de.adv.rfsprojekt.ur_new.urscript_builder;

import java.util.List;

public interface URScript {

    void addCommand(String command);

    void addURScript(URScript script);

    List<String> getCommands();

    void includesGripperCommand(boolean contains);

    String createURScriptString();

    String createProgramm();

}
