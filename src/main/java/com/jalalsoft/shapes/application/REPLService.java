package com.jalalsoft.shapes.application;

import com.jalalsoft.shapes.command.Command;
import com.jalalsoft.shapes.command.CommandFactory;
import com.jalalsoft.shapes.command.QuitCommand;
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
        QuitCommand quitCommand = new QuitCommand();

        String command;
        do {
            command = read(scanner);

            if (command == null) continue;

            String output = evaluate(command);
            if (output == null) {
                commandOutputStream.getOutStream().println("Invalid command.");

            } else {

                commandOutputStream.getOutStream().println(output);
            }
        } while (command == null || !command.equalsIgnoreCase(quitCommand.getName()));
    }

    private String evaluate(String userCommand) {
        String output;
        try ( Scanner scanner = new Scanner(userCommand)){

            Command cmd = null;
            if (scanner.hasNext()) {
                cmd = commandFactory.getCommand(scanner.next());
            }
            if (cmd == null) {
                return null;
            }
            String arguments = null;
            if (scanner.hasNext())
                arguments = scanner.nextLine();

            output = cmd.execute(arguments);
            scanner.close();
        } catch (IllegalArgumentException exception) {
            output = exception.getMessage();
        }
        return output;
    }

    private String read(Scanner scanner) {
        String command = null;
        if (scanner.hasNextLine()) {
            command = scanner.nextLine();
        }
        return command;
    }
}
