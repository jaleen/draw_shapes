package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.application.REPLService;
import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CommandsInputTest {
    private ByteArrayOutputStream outputStream = null;
    private PrintStream out = null;
    private REPLService replService = null;

    @Before
    public void setUp() {

        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
        replService = new REPLService();
    }

    @Test
    public void whenCreateCanvasCommand_thenCanvasCommandIssued() throws IOException {

        String commands = "c 20 4";
        InputStream in = new ByteArrayInputStream(commands.getBytes());

        REPLService replService = new REPLService();
        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);
        replService.takeCommands(commandInputStream, commandOutputStream);

        assertEquals("Command isn't executed successfully.", commands, outputStream.toString());

    }

    @Test
    public void givenMultipleCommands_whenQuitCommandIssues_thenProcessAllCommandsUntilQuitCommand() throws IOException {

        String commands = "c 20 4\nL 1 2 3 2\nq\n";
        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);
        replService.takeCommands(commandInputStream, commandOutputStream);

        assertEquals("Command isn't executed successfully.", commands, outputStream.toString());

    }
    @Test
    public void givenCommandInput_whenCommandIsCreateCanvas_thePrintCanvas() throws IOException {
        String commands = "c 20 4\nL 1 2 3 2\nq\n";
        InputStream in = new ByteArrayInputStream(commands.getBytes());

        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);
        replService.takeCommands(commandInputStream, commandOutputStream);

        assertEquals("Canvas boundary isn't marked correctly",
                "-------\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "-------\n",
                outputStream.toString());


    }
}
