package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class DrawLineTest {

    private LineMarker lineMarker;
    private LineCommand lineCommand;

    @Before
    public void setup(){
        lineMarker = new LineMarker('x');
        lineCommand = new LineCommand(lineMarker);
    }

    @Test
    public void givenCanvas_whenLineCommand_thenDrawLine(){

        int width = 5;
        int height = 1;
        Canvas canvas = null;
        canvas = new Canvas(width, height);

        lineCommand.execute("1 1 4 1");
        Assert.assertEquals("Line isn't printed correctly",
                "       \n" +
                        " xxxx  \n" +
                        "       \n", canvas.toString());

    }

}
