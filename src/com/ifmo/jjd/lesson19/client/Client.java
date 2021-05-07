package com.ifmo.jjd.lesson19.client;


import com.ifmo.jjd.lesson19.Connection;
import com.ifmo.jjd.lesson19.SimpleMessage;
import com.ifmo.jjd.lesson19.settings.CommandText;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }

    public void start(){
        String command;

        while (true){
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if ("exit".equals(command)) break;
            sendAndPrintMessage(SimpleMessage.getMessage("client", command));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message){
        try(Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("От сервера:\n " + fromServer.getText());
        } catch (IOException ioException) {
            System.out.println("Ошибка отправки - получения сообщения");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        } catch (Exception e) {
            System.out.println("Ошибка соединения");
        }
    }

}
