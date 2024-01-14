package edu.mipt.kozub.utils;

import edu.mipt.kozub.utils.Applyble;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static <T,P> List<P> function (List<T> t, Applyble<T, P> apply) {
        List<P> result = new ArrayList<>();
        for(T i: t){
            result.add(apply.apply(i));
        }
        return result;
    }

    public static <T> List<T> filter (List<T> t, Tested<T> test) {
        List<T> result = new ArrayList<>();
        for(T i: t){
            if (test.test(i)) result.add(i);
        }
        return result;
    }

    public static <T> T reduction (List<T> t, Reductor<T> reduct) {
        return reduct.reduct(t);
    }
}
