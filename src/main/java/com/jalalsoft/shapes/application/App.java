package com.jalalsoft.shapes.application;

import com.jalalsoft.shapes.command.CommandFactory;
import com.jalalsoft.shapes.config.Configuration;
import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;

import java.io.IOException;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {

    public static void main(String[] args) throws IOException {

        Configuration configuration = Configuration.init("shapes.properties");

        new REPLService(CommandFactory.init(configuration)).takeCommands(new CommandInputStream(System.in), new CommandOutputStream(System.out));


    }
}
