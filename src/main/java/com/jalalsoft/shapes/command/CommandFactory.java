package com.jalalsoft.shapes.command;

import java.util.HashMap;

public class CommandFactory {

    private HashMap<String, Command> commands = null;

    private CommandFactory() {
        commands = new HashMap<String, Command>();
    }

    /* Factory pattern */
    public static CommandFactory init() {
        final CommandFactory cf = new CommandFactory();
        Command cmd = new CreateCanvasCommand();
        cf.addCommand(cmd);

        return cf;
    }

    public void addCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public Command getCommand(String cmd) {
        return commands.get(cmd.toLowerCase());
    }
}
