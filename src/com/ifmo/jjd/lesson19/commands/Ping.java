package com.ifmo.jjd.lesson19.commands;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.interfaces.Command;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ping implements Command {

    @Override
    public void execute(Connection connection, SimpleMessage message, int count) throws Exception {
        long ping = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                - message.getDateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() ;
        connection.sendMessage(SimpleMessage.getMessage("Сервер", ping + "мс"));
    }
}
