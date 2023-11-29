package org.example;

import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("sun.")) {
            return super.loadClass(name);
        }
        try {
            String fileName = name.replace('.', '/') + ".class";
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new ClassNotFoundException(name);
            }
            byte[] bytes = is.readAllBytes();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}
