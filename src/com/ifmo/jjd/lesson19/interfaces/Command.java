package com.ifmo.jjd.lesson19.interfaces;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.commands.*;

import java.io.IOException;

public interface Command {
    void execute(Connection connection, SimpleMessage message, int count) throws Exception;
    static Command getCommand(String command){
        switch (command) {
            case "help": return new Help();
            case "count": return new Count();
            case "ping": return new Ping();
            case "exit": return new Exit();
            default: return new Default();
        }
    }
}
