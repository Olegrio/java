package com.ifmo.jjd.lesson18;

import java.io.FilterInputStream;
import java.io.IOException;

public class InputDecorator extends FilterInputStream implements XorDecorator {

    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected InputDecorator(java.io.InputStream in) {
        super(in);
    }

    @Override
    public byte[] readAllBytes() throws IOException {
        return super.readAllBytes();
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
