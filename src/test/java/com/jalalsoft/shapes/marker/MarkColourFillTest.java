package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class MarkColourFillTest {

    private String nl = System.lineSeparator();

    @Test
    public void givenFillColourCommand_whenCanvasEmpty_thenFillColour() {

        int x = 2;
        int y = 2;
        char colour = 'o';


        int width = 4;
        int height = 4;

        Canvas canvas = Canvas.getInstance(width, height);

        ColourFillMarker marker = new ColourFillMarker();
        marker.fill(x, y, colour, canvas);

        String expected = "      " + nl +
                " oooo " + nl +
                " oooo " + nl +
                " oooo " + nl +
                " oooo " + nl +
                "      " + nl;
        assertEquals("Canvas isn't filled correctly.", expected, canvas.toString());
    }

    @Test
    public void givenFillColourCommand_whenLineNearToMiddleWithShortOpening_thenFillColourOnBothSides() {

        int x = 2;
        int y = 2;
        char colour = 'o';


        int width = 6;
        int height = 6;

        Canvas canvas = Canvas.getInstance(width, height);
        canvas.mark(3, 1, 'x');
        canvas.mark(3, 2, 'x');
        canvas.mark(3, 3, 'x');
        canvas.mark(3, 4, 'x');
        canvas.mark(3, 5, 'x');

        ColourFillMarker marker = new ColourFillMarker();
        marker.fill(x, y, colour, canvas);

        String expected = "        " + nl +
                " ooxooo " + nl +
                " ooxooo " + nl +
                " ooxooo " + nl +
                " ooxooo " + nl +
                " ooxooo " + nl +
                " oooooo " + nl +
                "        " + nl;
        assertEquals("Canvas isn't filled correctly.", expected, canvas.toString());

    }

    @Test
    public void givenFillColourCommand_whenLineInMiddleWithoutOpening_thenFillColourOnOneSides() {

        int x = 4;
        int y = 4;
        char colour = 'o';


        int width = 6;
        int height = 6;

        Canvas canvas = Canvas.getInstance(width, height);
        canvas.mark(3, 1, 'x');
        canvas.mark(3, 2, 'x');
        canvas.mark(3, 3, 'x');
        canvas.mark(3, 4, 'x');
        canvas.mark(3, 5, 'x');
        canvas.mark(3, 6, 'x');

        ColourFillMarker marker = new ColourFillMarker();
        marker.fill(x, y, colour, canvas);

        String expected = "        " + nl +
                "   xooo " + nl +
                "   xooo " + nl +
                "   xooo " + nl +
                "   xooo " + nl +
                "   xooo " + nl +
                "   xooo " + nl +
                "        " + nl;
        assertEquals("Canvas isn't filled correctly.", expected, canvas.toString());

    }
}
