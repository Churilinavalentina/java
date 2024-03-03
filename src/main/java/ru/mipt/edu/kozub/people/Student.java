package ru.mipt.edu.kozub.people;

import ru.mipt.edu.kozub.annotation.Validate;
import ru.mipt.edu.kozub.other.Comparable;
import ru.mipt.edu.kozub.reflection.TestForStudent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


@Validate(TestForStudent.class)
public class Student implements Comparable<Student> {
    private String name;
    private List<Integer> grades = new ArrayList<>();

    private Deque<Action> actions = new ArrayDeque();

    public Student(String name, int... arr) {
        this.name = name;
        for (int x : arr) {
            if (x >= 2 && x <= 5) grades.add(x);
            else throw new IllegalArgumentException();
        }
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setName(String name) {
        String tmp = this.name;
        actions.push(() -> this.name = tmp);
        this.name = name;
    }

    public void setGrades(int... arr) {
        for (int x : arr) {
            if (x >= 2 && x <= 5) {
                this.grades.add(x);
                actions.push(() -> this.grades.remove(grades.size() - 1));
            } else throw new IllegalArgumentException();
        }
    }

    public void removeGrades(int index) {
        int grade = grades.get(index);
        actions.push(() -> grades.add(index, grade));
        this.grades.remove(index);
    }

    public void undo() {
        actions.pop().make();
    }
    public Save getSave() {
        return new SaveImpl();
    }
    @Override
    public String toString() {
        return name + ":" + grades;
    }

    public double average() {
        double average = 0;
        int count = 0;

        if (grades.isEmpty()) return 0;

        for (int i : grades) {
            average = average + i;
            count++;
        }
        return average / count;
    }

    public boolean excellent() {
        if (this.average() == 5) return true;
        return false;
    }

    public Integer Comparable(Student s) {
        Double s1 = this.average();
        Double s2 = s.average();

        if (s1 > s2) return 1;
        if (s1 == s2) return 0;
        return -1;
    }

    private class SaveImpl implements Save {
        String name = Student.this.name;
        List<Integer> grades = new ArrayList<>(Student.this.grades);

        @Override
        public  void  load(){
            Student.this.name = name;
            Student.this.grades = new ArrayList<>(grades);
        }
    }
}
