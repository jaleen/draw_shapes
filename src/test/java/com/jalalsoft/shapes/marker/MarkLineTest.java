package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class MarkLineTest {

    @Test
    public void givenCanvas_whenYCoordinatesAreSame_thenDrawHorizontalBaseLine() {

        int x1 = 1, y1 = 1;
        int x2 = 4, y2 = 1;
        char lineChar = 'x';

        Line line = new Line(x1, y1, x2, y2);
        int width = 5;
        int height = 1;
        Canvas canvas = null;
        canvas = new Canvas(width, height);
        LineMarker marker = new LineMarker();


        marker.mark(line, canvas, lineChar);

        assertEquals("Line isn't printed correctly",
                "       \n" +
                        " xxxx  \n" +
                        "       \n", canvas.toString());
    }
}
