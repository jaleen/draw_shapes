package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.ColourFillMarker;
import com.jalalsoft.shapes.model.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

/**
 * Created by jalal.deen on 17/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ColourFillCommandTest {
    @Mock
    private ColourFillMarker colourFillMarker;

    @Test
    public void givenValidFillArguments_thenFillCanvas(){
        ColourFillCommand colourFillCommand = new ColourFillCommand(colourFillMarker);
        

        ArgumentCaptor<Integer> xAargument = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> yAargument = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Character> colourAargument = ArgumentCaptor.forClass(Character.class);
        ArgumentCaptor<Canvas> canvasArgumentCaptor = ArgumentCaptor.forClass(Canvas.class);
        String arguments = "5 6 o";
        Canvas canvas = new Canvas(10,10);
        colourFillCommand.execute(arguments);
        verify(colourFillMarker).fill(xAargument.capture(),yAargument.capture(),colourAargument.capture(),canvasArgumentCaptor.capture());
        int expectedX = 5;
        int expectedY = 6;
        char expectedColour = 'o';
        assertEquals("x point for fill of currentCanvas is incorrectly captured.", expectedX, xAargument.getValue().intValue());
        assertEquals("y point for fill of currentCanvas is incorrectly captured.", expectedY,  yAargument.getValue().intValue());
        assertEquals("Colour for fill of currentCanvas is incorrectly captured.", expectedColour,  colourAargument.getValue().charValue());

    }


    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectXArguments_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = "a5 6";
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when x argument is incorrect");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectYArguments_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = "5 df6 o";
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when y argument is incorrect");
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenMissingYCanvasArguments_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = "5 o";
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when y argument is not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenMissingXAndY_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = "asdfdsafsad";
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when x,y and colour arguments are not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenAllParametersMissing_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = "";
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when no argument is not provided");
    }
    @Test (expected = IllegalArgumentException.class)
    public void whenAllParametersNull_thenThrowIllegalArguments(){
        ColourFillCommand fillCommand = new ColourFillCommand(colourFillMarker);

        String arguments = null;
        fillCommand.execute(arguments);

        fail("Expected Illegal Arguments Exception when arguments are not provided");
    }

}
