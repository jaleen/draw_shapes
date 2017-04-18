package com.jalalsoft.shapes.command;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public abstract class Command {
    private String commandName = null;
    protected Command(String commandName){
        this.commandName = commandName;
    }
    public String getName(){
        return commandName;
    }

    public abstract String execute(String arguments);
}
