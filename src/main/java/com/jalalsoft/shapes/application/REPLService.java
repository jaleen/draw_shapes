package com.jalalsoft.shapes.application;

import com.jalalsoft.shapes.command.Command;
import com.jalalsoft.shapes.command.CommandFactory;
import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class REPLService {
    private final CommandFactory commandFactory;

    public REPLService(CommandFactory commandFactory) {

        this.commandFactory = commandFactory;
    }

    public void takeCommands(CommandInputStream commandInputStream, CommandOutputStream commandOutputStream) throws IOException {


        Scanner scanner = new Scanner(commandInputStream.getInputStream());

        String command;
        do {
            command = read(scanner);

            String output = evaluate(command);

            commandOutputStream.getOutStream().println(output);
        } while (!command.equalsIgnoreCase("q"));
    }

    private String evaluate(String userCommand) {
        String output;
        Scanner scanner = new Scanner(userCommand);
        Command cmd = commandFactory.getCommand(scanner.next());
        String arguments = null;
        if (scanner.hasNext())
            arguments = scanner.nextLine();
        output = cmd.execute(arguments);
        return output;
    }

    private String read(Scanner scanner) {
        return scanner.nextLine();
    }
}
