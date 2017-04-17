package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.RectangleMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.validator.LineValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class DrawRectangleTest {

    @Test
    public void givenCanvas_whenRectangleCommand_thenDrawRectangle(){

        String arguments = "2 2 5 5";
        int width = 8;
        int height = 8;
        Canvas canvas = new Canvas(width, height);
        RectangleCommand rectangleCommand = new RectangleCommand(new RectangleMarker(new LineValidator(), 'x'));

        rectangleCommand.execute(arguments);

        assertEquals("Rectangle isn't marked correctly",
                "          \n" +
                        "          \n" +
                        "  xxxx    \n" +
                        "  x  x    \n" +
                        "  x  x    \n" +
                        "  xxxx    \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n", canvas.toString()

        );

    }
}
