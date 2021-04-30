package com.ifmo.jjd.lesson18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputDecorator extends FilterOutputStream implements XorDecorator  {

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public OutputDecorator(OutputStream out) {
        super(out);
    }


    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

}
