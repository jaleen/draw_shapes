package com.jalalsoft.shapes.command;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CommandCreationTest {

    CommandFactory commandFactory = null;

    @Before
    public void setup() {
        commandFactory = CommandFactory.init();
    }

    @Test
    public void givenCreateCanvasRequest_thenCanvasCommandCreated() {

        String cmd = "C";
        Command mockCreateCanvasCommand = mock(CanvasCommand.class);
        when(mockCreateCanvasCommand.getName()).thenReturn(cmd);
        commandFactory.addCommand(mockCreateCanvasCommand);
        Command command = commandFactory.getCommand(cmd);
        assertThat(command, instanceOf(CanvasCommand.class));
    }

    @Test
    public void whenGetCanvasCommandRequest_thenCanvasCommandAlreadyInitialised() {

        String cmd = "C";
        Command command = commandFactory.getCommand(cmd);
        assertThat("Create canvas command not initialised yet.", command, instanceOf(CanvasCommand.class));
    }

}
