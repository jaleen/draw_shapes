package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.model.Canvas;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CanvasCommand extends Command {
    private static final String commandName = "C";
    private CanvasMarker canvasMarker = null;


    protected CanvasCommand(CanvasMarker canvasMarker) {
        super(commandName);
        this.canvasMarker = canvasMarker;
    }

    @Override
    public String execute(String arguments) {
        if (arguments == null) {
            throw new IllegalArgumentException("Incorrect Canvas arguments. It should be in format 'c width height' e.g. c 5 7");
        }


        int height;
        int width;

        try(Scanner scanner = new Scanner(arguments)) {
            width = scanner.nextInt();
            height = scanner.nextInt();
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException("Incorrect Canvas arguments. It should be in format 'c width height' e.g. c 5 7", noSuchElementException);
        }

        Canvas currentCanvas = Canvas.getInstance(width, height);
        canvasMarker.markBoundary(currentCanvas);

        return currentCanvas.toString();

    }


}
