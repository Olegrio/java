package com.ifmo.jjd.lesson19.server;

import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.interfaces.Command;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.TreeSet;

public class Server {
    private int port;
    private Connection connection;
    private TreeSet<String> connections = new TreeSet<>();

    public Server(int port) {
        this.port = port;
    }

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(port)){ // ожидание клиентских подключений
            System.out.println("Сервер запущен");
            while (true){
                Socket newClient = serverSocket.accept(); // момент установки соединения с клиентом
                connections.add(newClient.toString());

                connection = new Connection(newClient);
                SimpleMessage message = connection.readMessage();
                Command action = Command.getCommand(message.getText());
                action.execute(connection, message, connections.size());
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщенияSimpleMessage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
