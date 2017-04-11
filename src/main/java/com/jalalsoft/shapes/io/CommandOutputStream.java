package com.jalalsoft.shapes.io;

import java.io.PrintStream;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CommandOutputStream {
    private PrintStream outStream;

    public CommandOutputStream(PrintStream out) {
        this.outStream = out;
    }

    public PrintStream getOutStream() {
        return outStream;
    }
}
