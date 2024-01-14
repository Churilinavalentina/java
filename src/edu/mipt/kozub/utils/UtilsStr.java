package edu.mipt.kozub.utils;

import java.util.List;

public class UtilsStr implements Applyble<String, Integer>, Tested<String>, Reductor<String> {
    @Override
    public Integer apply(String o) {
        return o.length();
    }

    @Override
    public boolean test(String s) {
        return s.length()>=3;
    }

    @Override
    public String reduct(List<String> list) {
        String result = "";
        for(String str: list){
            result = result+str;
        }
        return result;
    }
}
