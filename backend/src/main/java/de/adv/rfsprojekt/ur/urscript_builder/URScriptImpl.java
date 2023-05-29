package de.adv.rfsprojekt.ur.urscript_builder;

import de.adv.rfsprojekt.ur.urscript_commands.tools.robotiq_gripper.RobotIQGripperPreamble;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class URScriptImpl implements URScript {

    private final List<String> commands;

    private boolean includesGripperCommand = false;

    public URScriptImpl() {
        commands = new ArrayList<>();
    }

    @Override
    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public void addURScript(URScript script) {
        includesGripperCommand = includesGripperCommand || script.getIncludesGripperCommand();
        commands.addAll(script.getCommands());
    }

    @Override
    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String createURScriptString() {
        return StringUtils.join(commands, "\n");
    }


    public String createProgramm() {
        String commandString = "\t" + StringUtils.join(createURScriptString().split("\n"), "\n\t");
        String programm = "def program():\n" +
                commandString + "\n" +
                "end \n" +
                "programm()\n";
        return includesGripperCommand ? RobotIQGripperPreamble.getPreamble(commandString) : programm;
    }


    public void setIncludesGripperCommand(boolean contains) {
        includesGripperCommand = contains;
    }

    @Override
    public boolean getIncludesGripperCommand() {
        return includesGripperCommand;
    }


}
