package com.jalalsoft.shapes.command;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CreateCanvasCommand extends Command{
    private static final String commandName = "C";
    protected CreateCanvasCommand() {
        super(commandName);
    }

    @Override
    public String execute(String arguments) {
        return "-------\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------\n";
    }
}
