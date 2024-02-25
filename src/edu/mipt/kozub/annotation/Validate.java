package edu.mipt.kozub.annotation;

import edu.mipt.kozub.people.Student;

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
