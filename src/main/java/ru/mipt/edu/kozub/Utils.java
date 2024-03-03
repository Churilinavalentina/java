package ru.mipt.edu.kozub;

import ru.mipt.edu.kozub.annotation.Default;
import ru.mipt.edu.kozub.annotation.Invoke;
import ru.mipt.edu.kozub.geometry.line.Line;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static <T,P> List<P> map(List<T> t, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for(T i: t){
            result.add(function.apply(i));
        }
        return result;
    }

    public static <T> List<T> filter (List<T> t, Predicate<T> test) {
        List<T> result = new ArrayList<>();
        for(T i: t){
            if (test.test(i)) result.add(i);
        }
        return result;
    }

    public static <T> Optional<T> reduce (List<T> t, BinaryOperator<T> reduct) {
        if(t==null||t.isEmpty()) return Optional.empty();
        T res = t.get(0);
        for(int i = 1; i<t.size();i++){
            res=reduct.apply(res, t.get(i));
        }
        return Optional.of(res);
    }

    public static List<Field> fieldCollection(Class cl){
        List<Field> fields= new ArrayList<>();
        Class superCl = cl;
        while (!superCl.equals(new Object().getClass())){
            for(Field f: superCl.getDeclaredFields())
                fields.add(f);
            superCl = superCl.getSuperclass();
        }
        fields.stream().distinct();
        return fields;
    }

    public static void lineConnector(Line l1, Line l2){
        try {
            Field f1 = l2.getClass().getDeclaredField("start");
            f1.setAccessible(true);
            f1.set(l2, l1.getEnd());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> collect(String[] arg, Class...clazz){
        Map<String, String> metCl = new HashMap<>();
        for(Class cl:clazz){
            Stream<Method> met = Arrays.stream(cl.getMethods())
                    .filter(x->x.isAnnotationPresent(Invoke.class))
                    .filter(x -> x.getParameters().length==0)
                    .filter(x -> !x.getReturnType().equals(void.class));

            metCl = met.collect(Collectors.toMap(x -> x.getName(), x -> {
                try {
                    return (String) x.invoke(cl.getConstructors()[0].newInstance(arg));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        return metCl;
    }

    public static void reset(Object obj){
        Field[] fields = fieldCollection(obj.getClass()).toArray(new Field[0]);
        for(Field field:fields){
            if(field.isAnnotationPresent(Default.class)){
                field.setAccessible(true);
                try {
                    field.set(obj, field.getAnnotation(Default.class).Value());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
