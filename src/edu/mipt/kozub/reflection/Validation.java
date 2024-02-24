package edu.mipt.kozub.reflection;

import edu.mipt.kozub.people.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validation {
    public  static void validate(Object objectForTest, Class testedClass){
        try {
            Constructor cstr = testedClass.getDeclaredConstructors()[0];
            Object testedObject = cstr.newInstance();
            Method[] tests = testedClass.getDeclaredMethods();
            for(Method test:tests){
                test.invoke(testedObject, objectForTest);
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Validation OK");
    }
}

