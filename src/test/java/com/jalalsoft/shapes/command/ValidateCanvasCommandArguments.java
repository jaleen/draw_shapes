package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.CanvasMarker;
import com.jalalsoft.shapes.model.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jalal.deen on 14/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidateCanvasCommandArguments {

    @Mock
    private CanvasMarker canvasMarker;

    @Test
    public void givenValidCanvasArguments_thenDrawCanvas(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        ArgumentCaptor<Canvas> canvasArgumentCaptor = ArgumentCaptor.forClass(Canvas.class);
        String arguments = "5 6";
        canvasCommand.execute(arguments);
        verify(canvasMarker).markBoundary(canvasArgumentCaptor.capture());
        int expectedHeight = 6;
        int expectedWidth = 5;
        assertEquals("Height of canvas is incorrectly captured.", expectedHeight, canvasArgumentCaptor.getValue().getHeight()-2);
        assertEquals("Width of canvas is incorrectly captured.", expectedWidth, canvasArgumentCaptor.getValue().getWidth()-2);

    }
    @Test
    public void whenValidCanvasArgumentsWithExtraSpaces_thenDrawCanvas(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        ArgumentCaptor<Canvas> canvasArgumentCaptor = ArgumentCaptor.forClass(Canvas.class);
        String arguments = "  5   6  ";
        canvasCommand.execute(arguments);
        verify(canvasMarker).markBoundary(canvasArgumentCaptor.capture());
        int expectedHeight = 6;
        int expectedWidth = 5;
        assertEquals("Height of canvas is incorrectly captured.", expectedHeight, canvasArgumentCaptor.getValue().getHeight()-2);
        assertEquals("Width of canvas is incorrectly captured.", expectedWidth, canvasArgumentCaptor.getValue().getWidth()-2);

    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectWidthCanvasArguments_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = "a5 6";
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when width argument is incorrect");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectHeightCanvasArguments_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = "5 df6";
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when height argument is incorrect");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenMissingHeightCanvasArguments_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = "5";
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when height argument is not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenMissingHeightAndWidth_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = "asdfdsafsad";
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when height argument is not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenBothParametersMissing_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = "";
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when height argument is not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenBothParametersNull_thenThrowIllegalArguments(){
        CanvasCommand canvasCommand = new CanvasCommand(canvasMarker);

        String arguments = null;
        canvasCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when height argument is not provided");
    }

}
