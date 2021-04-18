package com.ifmo.jjd.lesson14;

import com.ifmo.jjd.lesson13.employee.Employee;

import java.util.*;

public class TextUtils {

    public static Map<String, Integer> getCountContains(String text, String string){
        HashMap<String, Integer> result = new HashMap<>();
        String s = string.toLowerCase();
        String tempString = text.toLowerCase().replaceAll(s,string + "_");
        result.put(s, tempString.split(s).length - 1);
        return result;
    }

    public static Map<Integer, ArrayList<String>> getCountContainsWords(String text){
        String[] array = text.toLowerCase().split(" ");
        HashMap<Integer, ArrayList<String>> result = new HashMap<>();
        for (String string : array) {
            String s = string.trim();
            if(!result.containsKey(s.length())){
                result.put(s.length(), new ArrayList<>());
            }
            result.get(s.length()).add(s);
        }
        return result;
    }

    public static void wordsMostOftenFount(String text){
        String[] array = text.toLowerCase().split(" ");
        TreeMap<String, Integer> countEqualsWord = new TreeMap<>();
        TreeMap<Integer, ArrayList<String>> result = new TreeMap<>();
        int indexOutput = 0;

        for (String string : array) {
            int value = countEqualsWord.getOrDefault(string.toLowerCase(), 0);
            countEqualsWord.put(string.toLowerCase(), value + 1);
        }

        for(Map.Entry<String, Integer> entry: countEqualsWord.entrySet()){
            int key = -1 * entry.getValue();
            if(!result.containsKey(key)){
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(entry.getKey());
        }

        for(Map.Entry<Integer, ArrayList<String>> entry: result.entrySet()){
            for (String item : entry.getValue()) {
                if(indexOutput >= 10) return;
                System.out.println("Слово '" + item + "' встречается " + -entry.getKey() + " раз");
                indexOutput++;
            }
        }
    }

    public static void getCountLetterEquals(String text){
        String string = text.replaceAll(" ", "").toLowerCase();
        HashMap<String, Integer> result = new HashMap<>();
        float weightLetter = 100f / string.length();
        System.out.println(weightLetter);
        System.out.println(string.length());
        for (String s : string.split("")) {
            result.put(s,result.getOrDefault(s, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: result.entrySet()){
            System.out.println(entry.getKey() + " - " + String.format("%.2f", entry.getValue()*weightLetter) + "%");
        }
    }

}
