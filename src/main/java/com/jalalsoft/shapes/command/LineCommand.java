package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class LineCommand extends Command {
    private static final String commandName = "L";
    private final LineMarker lineMarker;

    public LineCommand(LineMarker lineMarker) {

        super(commandName);
        this.lineMarker = lineMarker;
    }

    @Override
    public String execute(String commandArguments) {

        if(commandArguments==null){
            throw new IllegalArgumentException("Invalid line command. Use format L x1 y1 x2 y2 e.g. L 10 12 10 16");
        }
        try {
            Scanner scanner = new Scanner(commandArguments);


            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            Line line = new Line(x1, y1, x2, y2);

            lineMarker.mark(line, Canvas.getCurrentCanvas());
        }catch (NoSuchElementException nse){
            throw new IllegalArgumentException("Invalid line command. Use format L x1 y1 x2 y2 e.g. L 10 12 10 16");
        }
        return Canvas.getCurrentCanvas().toString();
    }
}
