package com.ifmo.jjd.lesson23.tak2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;

public class AppPoints {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Point> pointClass = Point.class;

        if(pointClass.isAnnotationPresent(Component.class)) { // проверка на наличие аннотации
            Component component = pointClass.getDeclaredAnnotation(Component.class); // для получения имени файла resources
            Constructor<Point> pointConstructor = pointClass.getDeclaredConstructor();
            Point point = pointConstructor.newInstance();

            Field[] fields = pointClass.getFields();
            Properties properties = new Properties();

            for (Field field : fields) {
                if(field.isAnnotationPresent(Required.class)){

                    try(InputStream input = AppPoints.class.getClassLoader().getResourceAsStream(component.fileName())){
                        properties.load(input);

                        switch (field.getName()) {
                            case "x" -> {
                                field.set(point, Integer.parseInt(properties.get("x").toString()));
                            }
                            case "y" -> {
                                field.set(point, Integer.parseInt(properties.get("y").toString()));
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Не удается прочитать файл");
                    }
                }
            }

            System.out.println(point.getX());
            System.out.println(point.getY());
        }
    }
}
