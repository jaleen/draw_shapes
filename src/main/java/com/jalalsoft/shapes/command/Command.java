package com.jalalsoft.shapes.command;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public abstract class Command {
    String commandName = null;
    protected Command(String commandName){
        this.commandName = commandName;
    }
    String getName(){
        return commandName;
    }
}
