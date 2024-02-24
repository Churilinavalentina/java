package edu.mipt.kozub;

import edu.mipt.kozub.geometry.line.Line;
import edu.mipt.kozub.geometry.line.Point;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

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
            System.out.println(l1.getClass().getDeclaredFields().toString());
            Field f1 = l2.getClass().getDeclaredField("start");

            f1.setAccessible(true);
            f1.set(l2, l1.getEnd());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
