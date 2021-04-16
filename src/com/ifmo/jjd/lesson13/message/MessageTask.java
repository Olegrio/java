package com.ifmo.jjd.lesson13.message;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int[] priorityCount = new int[Message.MessagePriority.values().length];
        for (Message message : messageList) {
            priorityCount[message.getPriority().ordinal()]++;
        }

//        for (int i = 0; i < priorityCount.length; i++) {
//            for (Message message : messageList) {
//                if(message.getPriority().equals(Message.MessagePriority.getPriority(i))){
//                    priorityCount[i] += 1;
//                }
//            }
//        }
        for (int i = 0; i < priorityCount.length; i++) {
            System.out.println(priorityCount[i] + " сообщений с приоритетом " + Message.MessagePriority.getPriority(i));
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
//        ArrayList<Integer> codeValues = new ArrayList<>();
//        ArrayList<Integer> codeValuesCount = new ArrayList<>();
//        int tempCodeValuesIndex;
//        for (Message message : messageList) {
//            if(codeValues.contains(message.getCode())){
//                tempCodeValuesIndex = codeValues.indexOf(message.getCode());
//                codeValuesCount.set(tempCodeValuesIndex, codeValuesCount.get(tempCodeValuesIndex) + 1);
//            } else {
//                codeValues.add(message.getCode());
//                codeValuesCount.add(0);
//            }
//        }

//        for (int i = 0; i < codeValues.size() - 1; i++) {
//            tempCodeValuesIndex = codeValues.get(i);
//            System.out.println(codeValuesCount.get(tempCodeValuesIndex) + " сообщений с кодом " + codeValues.get(i));
//        }

        HashMap<Integer, Integer> codeValues = new HashMap<>();

        for (Message message : messageList) {
            int value = codeValues.getOrDefault(message.getCode(), 0);
            codeValues.put(message.getCode(), value + 1 );
        }

        for(Map.Entry<Integer, Integer> entry: codeValues.entrySet()){
            System.out.println(entry.getValue() + " сообщений с кодом " + entry.getKey());
        }

    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        System.out.println(" уникальных сообщений: " + new HashSet<>(messageList).size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        List<Message> result = new ArrayList<>();
        for (Message message : messageList) {
            if(!result.contains(message)) {
                result.add(message);
            }
        }
        return result;
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> result = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority() == priority){
                result.add(message);
            }
        }
        return result;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> result = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority() != priority){
                result.add(message);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        //System.out.println(messages);

        // вызов методов

        // countEachPriority(messages);
        countEachCode(messages);
        // uniqueMessageCount(messages);
        // System.out.println(uniqueMessagesInOriginalOrder(messages));
        // System.out.println(copyEach(messages, Message.MessagePriority.HIGH));
        // System.out.println(copyOther(messages, Message.MessagePriority.HIGH));
    }
}
