package com.jalalsoft.shapes.application;

import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class REPLService {
    public void takeCommands(CommandInputStream commandInputStream, CommandOutputStream commandOutputStream) throws IOException {


        Scanner scanner = new Scanner(commandInputStream.getInputStream());

        String command = "";
        do {
            command = scanner.nextLine();
            commandOutputStream.getOutStream().println(command);
        } while (!command.equalsIgnoreCase("q"));



    }
}
