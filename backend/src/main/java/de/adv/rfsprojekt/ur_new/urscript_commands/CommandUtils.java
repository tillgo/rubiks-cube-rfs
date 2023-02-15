package de.adv.rfsprojekt.ur_new.urscript_commands;

import org.apache.commons.lang3.StringUtils;

public class CommandUtils {

    public static String COMBINE_COMMANDS_TO_PROGRAMM(String commands) {
        String commandString = StringUtils.join(commands.split("\n"), "\n\t");
        return "def program():\n" +
                commandString + "\n" +
                "end \n" +
                "programm()\n";

    }
}
