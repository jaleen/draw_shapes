package com.jalalsoft.shapes.command;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class CanvasCommandTest {

    @Test
    public void givenCanvasCommand_whenWidthHeightProvided_theDrawCanvas(){

        String canvasUserInput = "5 5";
        Command command = new CanvasCommand();

        String drawing = command.execute(canvasUserInput);

        String expectedDrawing = "-------\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------\n";
        assertEquals("Canvas isn't drawn correctly", expectedDrawing, drawing);

    }
    @Test
    public void givenCanvasCommand_whenWidthIsMoreThanHeight_theDrawCanvas(){

        String canvasUserInput = "5 7";
        Command command = new CanvasCommand();

        String drawing = command.execute(canvasUserInput);

        String expectedDrawing = "-------\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------\n";
        assertEquals("Canvas isn't drawn correctly", expectedDrawing, drawing);

    }

}
