package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by jalal.deen on 17/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LineCommandTest {
    @Mock
    private LineMarker lineMarker;
    @Mock
    private Canvas canvas;
    private char lineChar = 'x';
    private final String nl = System.lineSeparator();

    @Test
    public void givenLineCommand_whenWidthHeightProvided_thenInvokeMarker() {

        String lineCommandInput = "1 1 5 1";
        Command command = new LineCommand(lineMarker);

        Canvas canvas = Canvas.getInstance(6, 6);
        command.execute(lineCommandInput);

        verify(lineMarker, times(1)).mark(any(Line.class), eq(canvas));

    }
    @Test (expected = IllegalArgumentException.class)
    public void givenLineCommand_whenAllArgumentsMissing_thenThrowIllegalArgumentException() {

        String lineCommandInput = "";
        Command command = new LineCommand(lineMarker);

        command.execute(lineCommandInput);

    }
    @Test (expected = IllegalArgumentException.class)
    public void givenLineCommand_whenAllArgumentsNull_thenThrowIllegalArgumentException() {

        String lineCommandInput = null;
        Command command = new LineCommand(lineMarker);

        command.execute(lineCommandInput);

    }

    @Test (expected = IllegalArgumentException.class)
    public void givenLineCommand_whenSomeArgumentsMissing_thenThrowIllegalArgumentException() {

        String lineCommandInput = "1 2 3";
        Command command = new LineCommand(lineMarker);

        command.execute(lineCommandInput);

    }
    @Test (expected = IllegalArgumentException.class)
    public void givenLineCommand_whenSomeArgumentsHaveInvalidChars_thenThrowIllegalArgumentException() {

        String lineCommandInput = "1 adf2 3c 2 ";
        Command command = new LineCommand(lineMarker);

        command.execute(lineCommandInput);

    }

}
