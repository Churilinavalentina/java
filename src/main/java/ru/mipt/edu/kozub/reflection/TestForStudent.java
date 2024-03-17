package ru.mipt.edu.kozub.reflection;

import org.springframework.stereotype.Component;
import ru.mipt.edu.kozub.annotation.Test;
import ru.mipt.edu.kozub.people.Student;

@Component
public class TestForStudent {
    @Test
    void test1(Student student) {
        if (student.getName() == null)
            throw new AssertionError();
    }

    @Test
    public void test2(Student student) {
        if (student.getGrades().size() == 0) {
            throw new AssertionError();
        }
    }
}
