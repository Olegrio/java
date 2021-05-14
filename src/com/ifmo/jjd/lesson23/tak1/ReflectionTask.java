package com.ifmo.jjd.lesson23.tak1;

import java.lang.reflect.*;

public class ReflectionTask {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<Text> textClass = Text.class;
        Constructor<Text> textConstructor = textClass.getDeclaredConstructor(String.class);
        Text reflectText = textConstructor.newInstance("ReflectionLesson");

        toString(reflectText);
    }
    public static void toString(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field declaredField : fields) {
            if(!declaredField.getType().getTypeName().contains("Object")) {
                if (declaredField.getType().isAssignableFrom(String.class) || declaredField.getType().isAssignableFrom(int.class)
                        || declaredField.getType().isAssignableFrom(long.class) || declaredField.getType().isAssignableFrom(boolean.class)) {
                    System.out.println(declaredField.getName() + " - " + declaredField.getType());

                } else if (declaredField.getType().isArray()) {
                    System.out.println(declaredField.getName() + " - " + declaredField.getType().getTypeName());
                }
            }

        }


        // вывести в консоль все свойства объекта
    }
}
