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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by jalal.deen on 17/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MarkLineTest {
    @Mock
    private LineValidator lineValidator;
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
        LineMarker marker = new LineMarker(lineValidator);


        marker.mark(line, canvas, lineChar);

        assertEquals("Line isn't printed correctly",
                "       \n" +
                        " xxxx  \n" +
                        "       \n", canvas.toString());
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenLineCoordinatesAreInvalid_thenValidationIsPerformed() {

        int x1 = -1, y1 = 1;
        int x2 = 2, y2 = 3;
        char lineChar = 'x';

        Line line = new Line(x1, y1, x2, y2);
        int width = 5;
        int height = 5;
        Canvas canvas = null;
        canvas = new Canvas(width, height);
        LineMarker marker = new LineMarker(lineValidator);
        when(lineValidator.validate(any(Line.class), any(Canvas.class))).thenThrow(IllegalArgumentException.class);

        marker.mark(line, canvas, lineChar);
    }



}
