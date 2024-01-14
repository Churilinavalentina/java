package edu.mipt.kozub.utils;

import java.util.List;

public class UtilsInt implements Applyble<Integer, Integer>, Tested<Integer>, Reductor<Integer>{

    @Override
    public Integer apply(Integer integer) {
        if(integer > 0) return integer;
        return integer*-1;
    }

    @Override
    public boolean test(Integer integer) {
        return integer>0;
    }

    @Override
    public Integer reduct(List<Integer> list) {
        Integer sum = 0;
        for (Integer i:list){
            sum = sum + i;
        }
        return sum;
    }
}
