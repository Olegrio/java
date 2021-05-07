package com.ifmo.jjd.lesson19.commands;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.interfaces.Command;
import com.ifmo.jjd.lesson19.settings.CommandText;

import java.io.IOException;

public class Default implements Command {
    @Override
    public void execute(Connection connection, SimpleMessage message, int count) throws IOException {
        String commands = CommandText.HELP + CommandText.COUNT + CommandText.PING + CommandText.EXIT;
        connection.sendMessage(SimpleMessage.getMessage("Сервер", "Доступны только команды: " + commands));
    }

}
