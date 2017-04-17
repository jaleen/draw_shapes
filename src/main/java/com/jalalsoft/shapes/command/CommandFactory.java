package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.config.Configuration;
import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.marker.RectangleMarker;
import com.jalalsoft.shapes.validator.LineValidator;
import com.jalalsoft.shapes.validator.RectangleValidator;

import java.util.HashMap;

public class CommandFactory {

    private HashMap<String, Command> commands = null;

    private CommandFactory() {
        commands = new HashMap<String, Command>();
    }

    /* Factory pattern */
    public static CommandFactory init(Configuration configuration) {
        final CommandFactory cf = new CommandFactory();
        Command canvasCommand = createCanvasCommand(configuration);
        Command lineCommand = createLineCommand(configuration);
        Command rectangleCommand = createRectangleCommand(configuration);
        Command quitCmd = new QuitCommand();
        cf.addCommand(canvasCommand);
        cf.addCommand(quitCmd);
        cf.addCommand(lineCommand);
        cf.addCommand(rectangleCommand);

        return cf;
    }

    private static Command createRectangleCommand(Configuration configuration) {

        String lineChar = configuration.getPropertyValue("lineCharacter");

        return new RectangleCommand(new RectangleMarker(new RectangleValidator(),lineChar.trim().charAt(0)));
    }

    private static Command createLineCommand(Configuration configuration) {
        String lineChar = configuration.getPropertyValue("lineCharacter");
        LineMarker lineMarker= new  LineMarker(new LineValidator(), lineChar.trim().charAt(0));
        return new LineCommand(lineMarker);

    }

    private static Command createCanvasCommand(Configuration configuration) {
        String horizontalBoundaryCharacter = configuration.getPropertyValue("horizontalBoundaryCharacter");
        String verticalBoundaryCharacter = configuration.getPropertyValue("verticalBoundaryCharacter");

        return new CanvasCommand(new CanvasMarker(horizontalBoundaryCharacter.charAt(0), verticalBoundaryCharacter.trim().charAt(0)));
    }

    public void addCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }

    public Command getCommand(String cmd) {
        return commands.get(cmd.toLowerCase());
    }

}
