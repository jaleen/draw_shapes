package com.jalalsoft.shapes.command;

import com.jalalsoft.shapes.application.REPLService;
import com.jalalsoft.shapes.io.CommandInputStream;
import com.jalalsoft.shapes.io.CommandOutputStream;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class DrawCommandsTest {

    @Test
    public void whenCreateCanvasCommand_thenCanvasCommandIssued() throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        String commands = "c 20 4";
        InputStream in = new ByteArrayInputStream(commands.getBytes());


        REPLService replService = new REPLService();
        CommandInputStream commandInputStream = new CommandInputStream(in);
        CommandOutputStream commandOutputStream = new CommandOutputStream(out);
        replService.takeCommands(commandInputStream, commandOutputStream);


        assertEquals("Command isn't executed successfully. ", commands,outputStream.toString() );

    }
}
