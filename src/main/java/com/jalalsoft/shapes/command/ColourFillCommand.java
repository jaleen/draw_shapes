package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.ColourFillMarker;
import com.jalalsoft.shapes.model.Canvas;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class ColourFillCommand extends Command {

    private static final String commandName = "B";
    private ColourFillMarker marker = null;

    protected ColourFillCommand(ColourFillMarker marker) {
        super(commandName);
        this.marker = marker;
    }

    @Override
    public String execute(String arguments) {

        if (arguments == null) {
            throw new IllegalArgumentException("Incorrect fill colour arguments. It should be in format 'b x y colour' e.g. b 5 7 o");
        }

        int x;
        int y;
        char colour;
        try(Scanner scanner = new Scanner(arguments)) {

            x = scanner.nextInt();
            y = scanner.nextInt();
            colour = scanner.next(".").charAt(0);
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException("Incorrect fill colour arguments. It should be in format 'b x y colour' e.g. b 5 7 o", noSuchElementException);
        }
        Canvas canvas = Canvas.getCurrentCanvas();
        marker.fill(x, y, colour, canvas);

        return canvas.toString();
    }
}
