package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.LineMarker;
import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
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

        Canvas canvas = new Canvas(6, 6);
        command.execute(lineCommandInput);

        verify(lineMarker, times(1)).mark(any(Line.class), eq(canvas));

    }
}
