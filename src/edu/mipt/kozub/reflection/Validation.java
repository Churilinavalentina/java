package edu.mipt.kozub.reflection;

import edu.mipt.kozub.annotation.Validate;
import edu.mipt.kozub.people.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validation {
    public  static void validate(Class testedClass, Object...objectForTest){
        for(Object obj:objectForTest) {
            // Проверяем наличие класса в анотации аннотации -----------------------------------------------
            Class[] clazz = Validate.class.getAnnotation(Validate.class).value();
            Boolean searchObjInAnnotation = false;
            for(Class cl: clazz){
                if (cl.equals(obj.getClass())) searchObjInAnnotation = true;
            }
            //----------------------------------------------------------------------------------------------

            //Либо класс имеет аннотацию validation, либо в аннотации аннотации есть имя класса
            if (obj.getClass().isAnnotationPresent(Validate.class) || searchObjInAnnotation) {
                try {
                    Constructor cstr = testedClass.getDeclaredConstructors()[0];
                    Object testedObject = cstr.newInstance();
                    Method[] tests = testedClass.getDeclaredMethods();
                    for (Method test : tests) {
                        test.invoke(testedObject, obj);
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
}

