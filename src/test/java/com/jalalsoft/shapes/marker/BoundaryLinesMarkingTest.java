package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import com.jalalsoft.shapes.validator.LineValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 12/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BoundaryLinesMarkingTest {
    @Mock
    private LineValidator lineValidator;
    @Test
    public void whenXCoordinatesAreSame_thenDrawVerticalLine() {

        int x1 = 0, y1 = 1;
        int x2 = 0, y2 = 6;
        char lineChar = '|';
        Line line = new Line(x1, y1, x2, y2);
        int width = 5;
        int height = 6;
        Canvas canvas = null;
        canvas = new Canvas(width, height);
        LineMarker printer = new LineMarker(lineValidator);

        printer.mark(line, canvas, lineChar);

        assertEquals("Line isn't printed correctly",
                "       \n" +
                        "|      \n" +
                        "|      \n" +
                        "|      \n" +
                        "|      \n" +
                        "|      \n" +
                        "|      \n" +
                        "       \n", canvas.toString());

    }
    @Test
    public void whenYCoordinatesAreSame_thenDrawHorizontalLine() {

        int x1 = 0, y1 = 0;
        int x2 = 6, y2 = 0;
        char lineChar = '-';

        Line line = new Line(x1, y1, x2, y2);

        int width = 5;
        int height = 1;
        Canvas canvas = null;
        canvas = new Canvas(width, height);
        LineMarker printer = new LineMarker(lineValidator);

        printer.mark(line, canvas, lineChar);

        assertEquals("Line isn't printed correctly",
                "-------\n" +
                        "       \n" +
                        "       \n", canvas.toString());


    }
}
