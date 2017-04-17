package com.jalalsoft.shapes.command;

import static org.mockito.Mockito.*;

import com.jalalsoft.shapes.config.Configuration;
import com.jalalsoft.shapes.model.Line;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CommandCreationTest {

    CommandFactory commandFactory = null;

    @Before
    public void setup() throws IOException {
        Configuration configuration = Configuration.init("shapes-test.properties");
        commandFactory = CommandFactory.init(configuration);
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
        assertThat("Create currentCanvas command not initialised yet.", command, instanceOf(CanvasCommand.class));
    }
    @Test
    public void givenCreateLineRequest_thenLineCommandCreated() {

        String cmd = "L";
        Command mockCreateLineCommand = mock(LineCommand.class);
        when(mockCreateLineCommand.getName()).thenReturn(cmd);
        commandFactory.addCommand(mockCreateLineCommand);
        Command command = commandFactory.getCommand(cmd);
        assertThat(command, instanceOf(LineCommand.class));
    }
    @Test
    public void whenGetLineCommandRequest_thenLineCommandAlreadyInitialised() {

        String cmd = "L";
        Command command = commandFactory.getCommand(cmd);
        assertThat("Create Line command not initialised yet.", command, instanceOf(LineCommand.class));
    }

    @Test
    public void whenGetRectangleCommandRequest_thenRectangleCommandAlreadyInitialised() {

        String cmd = "R";
        Command command = commandFactory.getCommand(cmd);
        assertThat("Create rectangle command not initialised yet.", command, instanceOf(RectangleCommand.class));
    }
}
