package ru.mipt.edu.kozub.jbdc;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Integer DepartmentID;

    @JoinColumn(name = "department_id")
    @OneToOne
    Department Department;
    public Employee() {
    }

    public Employee(Integer id, String name, Integer DepartmentID) {
        this.id = id;
        this.name = name;
        this.DepartmentID = DepartmentID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmebt=" + DepartmentID +
                '}';
    }
}
