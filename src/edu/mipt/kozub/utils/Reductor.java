package edu.mipt.kozub.utils;

import java.util.List;

public interface Reductor<T> {
    T reduct(List<T> list);
}
