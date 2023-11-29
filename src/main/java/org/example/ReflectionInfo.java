package org.example;

import java.lang.reflect.*;

public class ReflectionInfo {
    public static void printClassInfo(String className) {
        try {
            CustomClassLoader classLoader = new CustomClassLoader();
            Class<?> clazz = classLoader.loadClass(className);

            System.out.println("Class Name: " + clazz.getName());
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.toString());
            }

            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.toString());
            }

            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        printClassInfo("java.util.ArrayList"); // Replace with the name of the class you want to parse
    }
}
