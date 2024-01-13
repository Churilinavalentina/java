package edu.mipt.kozub.people;

import edu.mipt.kozub.Comparable;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, int...arr) {
        this.name = name;
        for(int x:arr) {
            if (x >=2 && x<=5) grades.add(x);
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
        this.name = name;
    }

    public void setGrades(int...arr) {
        for(int x:arr) {
            if (x >=2 && x<=5) this.grades.add(x);
            else throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return name +":"+grades;
    }

    public double average() {
        double average=0;
        int count = 0;

        if (grades.isEmpty()) return 0;

        for (int i: grades){
            average = average+i;
            count++;
        }
        return average/count;
    }

    public boolean excellent() {
        if (this.average()==5) return true;
        return false;
    }

    public Integer Comparable(Student s){
        Double s1 = this.average();
        Double s2 = s.average();

        if (s1 > s2) return 1;
        if (s1 == s2) return 0;
        return -1;
    }

}
