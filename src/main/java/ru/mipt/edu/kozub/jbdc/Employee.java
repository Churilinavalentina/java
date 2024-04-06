package ru.mipt.edu.kozub.jbdc;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //private Integer DepartmentID;

    @Column(name = "depname")
    private String depname;

//    @JoinColumn(name = "departmentId")
//    @ManyToOne
//    Department department;
    public Employee() {
    }

    public Employee(Integer id, String name, String depName) {
        this.id = id;
        this.name = name;
        this.depname = depName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depName='" + depname + '\'' +
                '}';
    }
}
