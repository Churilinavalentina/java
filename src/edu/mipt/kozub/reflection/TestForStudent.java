package edu.mipt.kozub.reflection;

import edu.mipt.kozub.people.Student;

public class TestForStudent {
    void test1(Student student) {
        if (student.getName() == null)
            throw new AssertionError();
    }

    public void test2(Student student) {
        if (student.getGrades().size() == 0) {
            throw new AssertionError();
        }
    }
}
