package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.model.Canvas;

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
        Scanner scanner = new Scanner(arguments);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        Canvas canvas = new Canvas(width, height);

        canvasMarker.markBoundary(canvas);

        return canvas.toString();

    }
}
