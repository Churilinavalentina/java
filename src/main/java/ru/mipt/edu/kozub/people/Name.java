package ru.mipt.edu.kozub.people;

import ru.mipt.edu.kozub.annotation.Invoke;
import ru.mipt.edu.kozub.reflection.Entity;

public class Name extends Entity {
    private String firstName;
    private String secondName;
    private String surname;

    public Name() {}

    public Name(String firstName) {
        this.firstName = firstName;
    }

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Name(String firstName, String secondName, String surname) {
        this(firstName, secondName);
        if ((firstName==null || firstName=="") && (secondName==null || secondName=="") && (surname==null || surname=="")) throw new IllegalArgumentException();
        this.surname = surname;
    }

    @Invoke
    public String getFirstName() {
        return firstName;
    }

    @Invoke
    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    @Invoke
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    @Override
//    public String toString(){
//        String fullName = (secondName == null  ? "" : secondName + " ") +
//                (firstName == null ? "" : firstName + " ") +
//                (surname == null ? "" : surname + " ");
//        return fullName;
//    }
}
