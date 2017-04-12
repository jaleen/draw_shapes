package com.jalalsoft.shapes.canvas;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.model.Canvas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jalal.deen on 12/04/2017.
 */
public class MarkCanvasTest {
    @Test
    public void whenWidthAndHeightIsSame_thenDrawCanvas() {
        int width = 5;
        int height = 5;
        Canvas canvas = new Canvas(width, height);
        new CanvasMarker('-', '|').markBoundary(canvas);

        assertEquals("Canvas boundary isn't marked correctly",
                "-------\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "-------\n",
                canvas.toString());
    }

    @Test
    public void whenWidthIsGreaterThanHeight_thenDrawCanvas() {

        int width = 7;
        int height = 5;
        Canvas canvas = new Canvas(width, height);
        new CanvasMarker( '-', '|').markBoundary(canvas);

        assertEquals("Canvas boundary isn't marked correctly",
                "---------\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "---------\n",
                canvas.toString());
    }
    @Test
    public void whenWidthIsLessThanHeight_thenDrawCanvas() {

        int width = 7;
        int height = 8;
        Canvas canvas = new Canvas(width, height);
        new CanvasMarker( '-', '|').markBoundary(canvas);

        assertEquals("Canvas boundary isn't marked correctly",
                "---------\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "|       |\n" +
                        "---------\n",
                canvas.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWidthIsLessThanOne_thenShouldThrowException() {

        int width = 0;
        int height = 8;

        new Canvas(width, height);

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenHeightIsLessThanOne_thenShouldThrowException() {

        int width = 1;
        int height = 0;

        new Canvas(width, height);

    }
}
