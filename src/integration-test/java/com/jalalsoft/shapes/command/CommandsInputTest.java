package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.application.REPLService;
import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by jalal.deen on 11/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandsInputTest {
    private ByteArrayOutputStream outputStream = null;
    private PrintStream out = null;
    private REPLService replService = null;
    private String canvasCommandName = "c";
    private String quitCommandName = "q";
    private String lineCommandName = "L";
    private String recCommandName = "R";
    private static final String nl = System.lineSeparator();
    @Mock
    private CommandFactory commandFactory;

    @Mock
    private Command canvasCommand;
    @Mock
    private Command lineCommand;
    @Mock
    private Command recCommand;
    @Mock
    private Command quitCommand;

    @Before
    public void setUp() {

        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
        replService = new REPLService(commandFactory);
    }

    @Test
    public void whenCreateCanvasCommand_thenCanvasCommandIssued() throws IOException {

        //given
        String userCommand = "c 20 4" + nl + quitCommandName + nl;
        InputStream in = new ByteArrayInputStream(userCommand.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);

        String commandName = "c";
        when(commandFactory.getCommand(commandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);
        when(canvasCommand.execute(any())).thenReturn(canvasCommandName);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);
        //when
        replService.takeCommands(commandInputStream, commandOutputStream);

        //then
        String expected = canvasCommandName + nl + quitCommandName + nl;
        assertEquals("Command isn't executed successfully.", expected, outputStream.toString());

    }

    @Test
    public void givenMultipleCommands_whenQuitCommandIssues_thenProcessAllCommandsUntilQuitCommand() throws IOException {

        //given
        String commands = "c 20 4" + nl + "L 1 2 3 2" + nl + "q" + nl + "";
        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);

        when(commandFactory.getCommand(canvasCommandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);
        when(commandFactory.getCommand(lineCommandName)).thenReturn(lineCommand);

        when(canvasCommand.execute(any())).thenReturn(canvasCommandName);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);
        when(lineCommand.execute(any())).thenReturn(lineCommandName);

        //when
        replService.takeCommands(commandInputStream, commandOutputStream);

        //then
        assertEquals("Commands aren't executed successfully.", "c" + nl + "L" + nl + "q" + nl, outputStream.toString());

    }

    @Test
    public void givenCommandInput_whenCommandIsCreateCanvas_thenPrintCanvas() throws IOException {
        String commands = "c 20 4" + nl + "q" + nl + "";

        String canvasOutput = "-------" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "-------";

        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);


        when(commandFactory.getCommand(canvasCommandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);
        //when(commandFactory.getCommand(lineCommandName)).thenReturn(lineCommand);

        when(canvasCommand.execute(any())).thenReturn(canvasOutput);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);

        replService.takeCommands(commandInputStream, commandOutputStream);
        String expectedOutput = canvasOutput + nl + "q" + nl;

        assertEquals("Canvas boundary isn't marked correctly",
                expectedOutput,
                outputStream.toString());
    }

    @Test
    public void givenCommandDoesNotExist_thenContinueGracefullyWithoutException() throws IOException {
        String commands = "badCommand" + nl + "c 20 4" + nl + "q" + nl;

        String canvasOutput =
                "-------" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "-------";

        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);


        when(commandFactory.getCommand(canvasCommandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);

        when(canvasCommand.execute(any())).thenReturn(canvasOutput);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);

        replService.takeCommands(commandInputStream, commandOutputStream);

        String expectedCanvasOutput = "Invalid command." + nl + canvasOutput + nl + "q" + nl;

        assertEquals("Canvas boundary isn't marked correctly",
                expectedCanvasOutput,
                outputStream.toString());
    }

    @Test
    public void givenCommand_whenArgumentsInvalid_thenContinueGracefullyWithoutException() throws IOException {

        String badArgument = " badArgument 4";
        String goodCanvasArguments = " 20 4";
        String goodCanvasCommand = "c" + goodCanvasArguments;
        String commands = "c" + badArgument + nl + goodCanvasCommand + nl + "q" + nl;

        String canvasOutput =
                "-------" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "|     |" + nl +
                        "-------";

        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);


        when(commandFactory.getCommand(canvasCommandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);

        when(canvasCommand.execute(badArgument)).thenThrow(IllegalArgumentException.class);
        when(canvasCommand.execute(goodCanvasArguments)).thenReturn(canvasOutput);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);

        replService.takeCommands(commandInputStream, commandOutputStream);

        String expectedCanvasOutput = "Invalid command." + nl + canvasOutput + nl + "q" + nl;

        assertEquals("Canvas boundary isn't marked correctly",
                expectedCanvasOutput,
                outputStream.toString());
    }

    @Test
    public void givenNoCommandInput_whenUserInputsEnterButton_thenGracefullyWaitForNextCommand() throws IOException {
        String commands = nl + "c 20 4" + nl + "q" + nl + "";

        String canvasOutput = "-------" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "|     |" + nl + "" +
                "-------";

        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);


        when(commandFactory.getCommand(canvasCommandName)).thenReturn(canvasCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);

        when(canvasCommand.execute(any())).thenReturn(canvasOutput);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);

        replService.takeCommands(commandInputStream, commandOutputStream);
        String expectedOutput = "Invalid command." + nl + canvasOutput + nl + "q" + nl;

        assertEquals("Canvas boundary isn't marked correctly",
                expectedOutput,
                outputStream.toString());
    }
    @Test
    public void whenDrawLineCommand_thenLineCommandIssued() throws IOException {

        //given
        String userCommand = "L 10 4 10 7" + nl + quitCommandName + nl;
        InputStream in = new ByteArrayInputStream(userCommand.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);

        when(commandFactory.getCommand(lineCommandName)).thenReturn(lineCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);
        when(lineCommand.execute(any())).thenReturn(lineCommandName);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);
        //when
        replService.takeCommands(commandInputStream, commandOutputStream);

        //then
        String expected = lineCommandName + nl + quitCommandName + nl;
        assertEquals("Command isn't executed successfully.", expected, outputStream.toString());

    }
    @Test
    public void whenDrawRectangleCommand_thenRectangleCommandIssued() throws IOException {

        //given
        String userCommand = "R 10 4 15 8" + nl + quitCommandName + nl;
        InputStream in = new ByteArrayInputStream(userCommand.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);

        when(commandFactory.getCommand(recCommandName)).thenReturn(recCommand);
        when(commandFactory.getCommand(quitCommandName)).thenReturn(quitCommand);
        when(recCommand.execute(any())).thenReturn(recCommandName);
        when(quitCommand.execute(any())).thenReturn(quitCommandName);
        //when
        replService.takeCommands(commandInputStream, commandOutputStream);

        //then
        String expected = recCommandName + nl + quitCommandName + nl;
        assertEquals("Command isn't executed successfully.", expected, outputStream.toString());

    }
}
