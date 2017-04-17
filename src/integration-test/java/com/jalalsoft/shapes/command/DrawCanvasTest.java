package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.validator.LineValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class DrawCanvasTest {


    private CanvasMarker canvasMarker;
    private LineValidator lineValidator;

    @Before
    public void setup(){

        canvasMarker = new CanvasMarker('-','|');
    }

    @Test
    public void givenCanvasCommand_whenWidthHeightProvided_theDrawCanvas(){

        String canvasUserInput = "5 5";
        Command command = new CanvasCommand(canvasMarker);

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
        Command command = new CanvasCommand(canvasMarker);

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
