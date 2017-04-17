package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.ColourFillMarker;
import com.jalalsoft.shapes.model.Canvas;

import java.util.Scanner;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class ColourFillCommand extends Command {

    private static final String commandName = "B";

    protected ColourFillCommand() {
        super(commandName);
    }

    @Override
    public String execute(String arguments) {

        Scanner scanner = new Scanner(arguments);

        int x;
        int y;
        char colour;

        x = scanner.nextInt();
        y = scanner.nextInt();
        colour =  scanner.next(".").charAt(0);

        ColourFillMarker marker = new ColourFillMarker();
        Canvas canvas = Canvas.getCurrentCanvas();
        marker.fill(x,y,colour, canvas);

        return canvas.toString();
    }
}
