package ru.mipt.edu.kozub.annotation;

import ru.mipt.edu.kozub.people.Student;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Validate(value = {Student.class})
public @interface Validate {
    Class[] value();
}
