package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
        new CanvasMarker('-', '|').markBoundary(canvas);

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

    @Test
    public void whenCanvasPointAlreadyMarked_thenReturnTrue(){

        int width = 3;
        int height = 3;

        Canvas canvas = new Canvas(width, height);
        canvas.mark(1,1,'x');

        assertTrue("Canvas should have been marked.", canvas.isMarked(1,1));

    }

    @Test
    public void whenCanvasPointIsNotMarked_thenReturnFalse(){

        int width = 3;
        int height = 3;

        Canvas canvas = new Canvas(width, height);
        canvas.mark(1,1,'x');

        assertFalse("Canvas should'nt be marked.", canvas.isMarked(1,2));

    }
    @Test
    public void whenCanvasPointIsWithinCanvas_thenReturnTrue(){

        int width = 3;
        int height = 3;

        Canvas canvas = new Canvas(width, height);


        assertTrue("Canvas should'nt be marked.", canvas.isWithinCanvas(1,2));

    }

    @Test
    public void whenCanvasPointIsNotWithinCanvas_thenReturnFalse(){

        int width = 3;
        int height = 3;

        Canvas canvas = new Canvas(width, height);


        assertFalse("Canvas should'nt be marked.", canvas.isWithinCanvas(-1,2));

    }



}
