package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.config.Configuration;
import com.jalalsoft.shapes.marker.CanvasMarker;

import java.util.HashMap;

public class CommandFactory {

    private HashMap<String, Command> commands = null;

    private CommandFactory() {
        commands = new HashMap<String, Command>();
    }

    /* Factory pattern */
    public static CommandFactory init(Configuration configuration) {
        final CommandFactory cf = new CommandFactory();
        Command cmd = createCanvasCommand(configuration);
        Command quitCmd = new QuitCommand();
        cf.addCommand(cmd);
        cf.addCommand(quitCmd);

        return cf;
    }

    private static Command createCanvasCommand(Configuration configuration) {
        String horizontalBoundaryCharacter = configuration.getPropertyValue("horizontalBoundaryCharacter");
        String verticalBoundaryCharacter = configuration.getPropertyValue("verticalBoundaryCharacter");

        return new CanvasCommand(new CanvasMarker(horizontalBoundaryCharacter.charAt(0), verticalBoundaryCharacter.charAt(0)));
    }

    public void addCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public Command getCommand(String cmd) {
        return commands.get(cmd.toLowerCase());
    }

}
