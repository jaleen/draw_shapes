package com.jalalsoft.shapes.command;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class QuitCommand extends Command {

    private static final String commandName = "q";
    public QuitCommand() {
        super(commandName);
    }

    @Override
    public String execute(String arguments) {
        return "Good Bye.";
    }
}
