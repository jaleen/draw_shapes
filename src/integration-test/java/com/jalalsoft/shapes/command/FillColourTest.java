package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.model.Canvas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class FillColourTest {


    private String nl = System.lineSeparator();

    @Test
    public void givenFillColourCommand_whenCanvasEmpty_thenFillColour(){

        String fillCommandArgs = "3 3 o";

        int width = 4;
        int height = 4;
        Command command =  new ColourFillCommand();
        Canvas canvas = new Canvas(width, height);
        command.execute(fillCommandArgs);

        String expected = "      "+nl+
                " oooo "+nl+
                " oooo "+nl+
                " oooo "+nl+
                " oooo "+nl+
                "      "+nl;
        assertEquals("Canvas isn't filled correctly.",expected,canvas.toString());

    }
}
