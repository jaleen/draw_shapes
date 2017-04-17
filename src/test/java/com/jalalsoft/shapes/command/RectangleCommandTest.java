package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.marker.RectangleMarker;
import org.junit.Test;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class RectangleCommandTest {

    private RectangleMarker recMarker=null;

    @Test(expected = IllegalArgumentException.class)
    public void givenRecCommand_whenAllArgumentsMissing_thenThrowIllegalArgumentException() {

        String commandInput = "";
        Command command = new RectangleCommand(recMarker);

        command.execute(commandInput);

    }
    @Test (expected = IllegalArgumentException.class)
    public void givenRecCommand_whenAllArgumentsNull_thenThrowIllegalArgumentException() {

        String commandInput = null;
        Command command = new RectangleCommand(recMarker);

        command.execute(commandInput);

    }

    @Test (expected = IllegalArgumentException.class)
    public void givenRecCommand_whenSomeArgumentsMissing_thenThrowIllegalArgumentException() {

        String commandInput = "1 2 3";
        Command command = new RectangleCommand(recMarker);

        command.execute(commandInput);

    }
    @Test (expected = IllegalArgumentException.class)
    public void givenRecCommand_whenSomeArgumentsHaveInvalidChars_thenThrowIllegalArgumentException() {

        String commandInput = "1 adf2 3c 2 ";
        Command command = new RectangleCommand(recMarker);

        command.execute(commandInput);

    }

}
