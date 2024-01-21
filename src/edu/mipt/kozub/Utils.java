package edu.mipt.kozub;

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
}
