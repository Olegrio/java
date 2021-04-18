package com.ifmo.jjd.lesson14;

import java.util.*;

public class Customer {
    private String name;
    private String uuid;
    private int age;

    public Customer(String name, String uuid, int age) {
        this.name = name;
        this.uuid = uuid;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name) &&
                Objects.equals(uuid, customer.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<String> getLoginForCity(HashMap<String, String> map, String city){
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, String> entry: map.entrySet()){
            if(entry.getValue().equals(city)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static Map<String, Integer> getCountEqualWords(List<String> strings){
        HashMap<String, Integer> result = new HashMap<>();
        for (String string : strings) {
            result.put(string,result.getOrDefault(string, 0) + 1);
        }
        return result;
    }

    public static Map<String, Customer> getCustomerForAge(HashMap<String, Customer> map, int from, int to){
        HashMap<String, Customer> result = new HashMap<>();
        for(Map.Entry<String, Customer> entry: map.entrySet()){
            if(entry.getValue().getAge() >= from && entry.getValue().getAge() < to){
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }



    // TODO: переопределить все необходимые методы
}