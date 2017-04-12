package com.jalalsoft.shapes.io;

import java.io.InputStream;

/**
 * Created by jalal.deen on 11/04/2017.
 */
public class CommandInputStream {
    private InputStream inputStream;

    public CommandInputStream(InputStream in) {
        this.inputStream = in;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
