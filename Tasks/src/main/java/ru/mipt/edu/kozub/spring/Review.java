package ru.mipt.edu.kozub.spring;

public class Review {
    private String text;
    private int grade;

    public Review(String text, int grade) {
        this.text = text;
        this.grade = grade;
    }

    public String getText() {
        return text;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Review{" +
                "text='" + text + '\'' +
                ", grade=" + grade +
                '}';
    }
}
