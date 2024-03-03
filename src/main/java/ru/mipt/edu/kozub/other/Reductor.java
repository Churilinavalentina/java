package ru.mipt.edu.kozub.other;

import java.util.List;

public interface Reductor<T> {
    T reduct(List<T> list);
}
