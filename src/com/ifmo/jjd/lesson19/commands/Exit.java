package com.ifmo.jjd.lesson19.commands;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.interfaces.Command;

public class Exit implements Command {
    @Override
    public void execute(Connection connection, SimpleMessage message, int count) throws Exception {
        connection.close();
    }

}
