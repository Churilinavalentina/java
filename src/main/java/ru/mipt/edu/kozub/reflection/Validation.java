package ru.mipt.edu.kozub.reflection;

import ru.mipt.edu.kozub.annotation.Test;
import ru.mipt.edu.kozub.annotation.Validate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validation {
    public  static void validate(Object...objectForTest){
        for(Object obj:objectForTest) {
            try {
                Class[] testClasses = obj.getClass().getDeclaredAnnotation(Validate.class).value();
                for (Class testClass : testClasses) {
                    Constructor cstr = testClass.getDeclaredConstructors()[0];
                    Object testedObject = cstr.newInstance();
                    Method[] tests = testClass.getDeclaredMethods();
                    for (Method test : tests) {
                        if (!test.isAnnotationPresent(Test.class)) continue;
                        test.setAccessible(true);
                        test.invoke(testedObject, obj);
                    }
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Validation " + obj + " OK");
        }
    }
}

