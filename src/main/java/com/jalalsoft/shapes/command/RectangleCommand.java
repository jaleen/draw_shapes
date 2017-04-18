package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.RectangleMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Rectangle;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class RectangleCommand extends Command {

    private final static String commandName = "R";
    private RectangleMarker rectangleMarker;

    protected RectangleCommand(RectangleMarker rectangleMarker) {
        super(commandName);
        this.rectangleMarker = rectangleMarker;
    }

    @Override
    public String execute(String arguments) {
        if (arguments == null) {
            throw new IllegalArgumentException("Invalid rectangle command. Use format R x1 y1 x2 y2 e.g. L 10 12 10 16");
        }
        try (  Scanner scanner = new Scanner(arguments)){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            Rectangle rectangle = new Rectangle(x1, y1, x2, y2);

            rectangleMarker.mark(rectangle, Canvas.getCurrentCanvas());
        } catch (NoSuchElementException nse) {
            throw new IllegalArgumentException("Invalid line command. Use format L x1 y1 x2 y2 e.g. L 10 12 10 16",nse);
        }
        return Canvas.getCurrentCanvas().toString();
    }
}
