package edu.mipt.kozub.reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Stream;

public class ObjectsReader<T> {
    private String nameFile;

    public ObjectsReader(String nameFile) {
        this.nameFile = nameFile;
    }

    public List<T> read(){
        List<T> results = new ArrayList<>();
        File f = new File(nameFile);
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNextLine()) {
            String[] allStr = sc.nextLine().split("\\{");
            String className = allStr[0];
            String[] arg = allStr[1].split("\\}")[0].split(",");
            String[] argValue = Arrays.stream(arg).map(x -> x.substring(x.indexOf("=")+1)).toArray(String[]::new);

            Class<?> clazz = null;
            try {
                clazz = Class.forName(className);
                Constructor<?> ctor = clazz.getConstructors()[0];
                T object = (T) ctor.newInstance(argValue);
                results.add((T) object);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return results;
    }
}
