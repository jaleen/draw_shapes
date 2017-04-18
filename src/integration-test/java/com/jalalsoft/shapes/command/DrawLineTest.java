package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.validator.LineValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DrawLineTest {

    private LineMarker lineMarker;
    private LineCommand lineCommand;
    private LineValidator lineValidator;

    @Before
    public void setup(){
        lineValidator = new LineValidator();
        lineMarker = new LineMarker(lineValidator, 'x');
        lineCommand = new LineCommand(lineMarker);
    }

    @Test
    public void givenCanvas_whenLineCommand_thenDrawLine(){

        int width = 5;
        int height = 1;
        Canvas canvas = null;
        canvas = Canvas.getInstance(width, height);

        lineCommand.execute("1 1 4 1");
        Assert.assertEquals("Line isn't printed correctly",
                "       \n" +
                        " xxxx  \n" +
                        "       \n", canvas.toString());

    }

}
