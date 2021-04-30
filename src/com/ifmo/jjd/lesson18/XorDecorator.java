package com.ifmo.jjd.lesson18;

public interface XorDecorator {

    default byte[] encode(String text) {
        byte[] textBytes = text.getBytes();
        byte[] key = Settings.KEY.getBytes();
        byte[] result = new byte[text.length()];

        for (int i = 0; i < text.length(); i++) {
            result[i] = (byte) (textBytes[i] ^ key[0]);
        }

        return result;
    }
    default String decode(byte[] text) {
        byte[] result = new byte[text.length];
        byte[] key = Settings.KEY.getBytes();

        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (text[i] ^ key[0]);
        }

        return new String(result);
    }
}

