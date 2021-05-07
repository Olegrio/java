package com.ifmo.jjd.lesson19;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket; // устанавливает соединение между программами
        output = new ObjectOutputStream(socket.getOutputStream()); // сначала открывается output потом input, иначе блокировка канала
        input = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush(); // байты из программы уходят в поток (при работе с сетью)
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close(); // закрывается последним
    }
}

