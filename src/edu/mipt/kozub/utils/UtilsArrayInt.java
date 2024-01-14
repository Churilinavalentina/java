package edu.mipt.kozub.utils;

import java.util.List;

public class UtilsArrayInt implements Applyble<Integer[], Integer>, Tested<Integer[]>, Reductor<Integer[]>{

    @Override
    public Integer apply(Integer[] integers) {
        int max = integers[0]; // начальное значение максимального элемента
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] > max) {
                max = integers[i];
            }
        }
        return max;
    }

    @Override
    public boolean test(Integer[] integers) {
        return apply(integers) <= 0;
    }

    @Override
    public Integer[] reduct(List<Integer[]> list) {
        Integer[] count = new Integer[list.size()];
        for (int i =0; i<list.size();i++){
            count[i] = list.get(i).length;
        }
        return count;
    }
}
