package de.adv.rfsprojekt.ur.urscript_builder;

import java.util.List;

public interface URScript {

    void addCommand(String command);

    void addURScript(URScript script);

    List<String> getCommands();

    void setIncludesGripperCommand(boolean contains);

    boolean getIncludesGripperCommand();

    String createURScriptString();

    String createProgramm();

}
