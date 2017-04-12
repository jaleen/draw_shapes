package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.model.Canvas;

import java.util.Scanner;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CanvasCommand extends Command{
    private static final String commandName = "C";
    protected CanvasCommand() {
        super(commandName);
    }

    @Override
    public String execute(String arguments) {
        Scanner scanner = new Scanner(arguments);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        Canvas canvas = new Canvas(width, height);

        return canvas.toString();

    }
}
