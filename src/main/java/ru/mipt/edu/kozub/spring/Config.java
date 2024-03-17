package ru.mipt.edu.kozub.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mipt.edu.kozub.people.Student;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    public String helloWorld() {
        return "Hello world";
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> listInit(int min, int max){
        for (int i = min; i <= max; i++){
            list.add(i);
        }
        return list;
    }
    @Bean
    @Scope("prototype")
    public int randomBean(int min, int max) {
        if (list.size() <1) listInit(min, max);
        int randomIndex = (int) (Math.random() *(list.size()));
        int result = list.get(randomIndex);
        list.remove(randomIndex);
        return result;
    }

    @Bean @Lazy
    public Date firstDate() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return number -> number >- 2 && number <= 5;
    }

    @Bean
    public int max() {
        return 3;
    }

    @Bean
    public int min() {
        return 1;
    }

    @Bean
    public Review review1() {
        return new Review("Very good", 4);
    }
    @Bean
    public Review review2() {
        return new Review("Good", 3);
    }
    @Bean
    public Review review3(int randomBean) {
        return new Review("Hard to say", randomBean);
    }

    @Bean
    @Scope("prototype")
    public Optional<Review> review4(List<Review> ctx) {
        return ctx.stream()
                .max(Comparator.comparingInt(review -> review.getGrade()));

    }

    @Bean
    @Scope("prototype")
    public Student student1(Predicate<Integer> range) {
        return new Student("Ivan", range, 5);
    }

    @Bean
    @Scope("prototype")
    public Student student2(Predicate<Integer> range, int...grades) {
        return new Student("Pety", range, 5,3,4);
    }
}
