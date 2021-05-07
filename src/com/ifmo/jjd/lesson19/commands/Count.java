package com.ifmo.jjd.lesson19.commands;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.interfaces.Command;

import java.io.IOException;

public class Count implements Command {
    @Override
    public void execute(Connection connection, SimpleMessage message, int count) throws Exception {
        connection.sendMessage(SimpleMessage.getMessage("Сервер", "Количество клиентов подключались к серверу: " + count));
    }
}
