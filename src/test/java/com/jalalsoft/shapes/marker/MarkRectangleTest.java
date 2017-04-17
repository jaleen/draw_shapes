package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Rectangle;
import com.jalalsoft.shapes.validator.LineValidator;
import com.jalalsoft.shapes.validator.RectangleValidator;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class MarkRectangleTest {

    @Mock
    RectangleValidator rectangleValidator;

    @Test
    public void givenCoordinates_thenMarkRectangle() {
        Rectangle rectangle = new Rectangle(2, 2, 5, 5);
        Canvas canvas = new Canvas(8, 8);
        new RectangleMarker(rectangleValidator, 'x').mark(rectangle, canvas);

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
