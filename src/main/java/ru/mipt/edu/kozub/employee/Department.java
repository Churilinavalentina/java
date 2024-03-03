package ru.mipt.edu.kozub.employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Employee boss;
    List<Employee> employee = new ArrayList<>();

    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public List<Employee> getEmployee() {
        return new ArrayList<>(employee);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoss(Employee boss) {
        addEmployee(boss);
        this.boss = boss;
    }

    public void addEmployee(Employee employee) {
        if(employee==null) return;
        if(employee.department==this) return;
        if(employee.department!=null) employee.department.removeEmployee(employee);
        employee.department=this;
        this.employee.add(employee);
    }

    public void removeEmployee(Employee employee) {
        if(employee==null) return;
        if (!this.employee.contains(employee)) return;
        if(boss==employee) boss=null;
        this.employee.remove(employee);
        employee.department=null;
    }
    @Override
    public String toString(){
        String tmp = " with no boss";
        if(boss!=null)
            tmp = " , the boss is " + boss.getName();
        return this.name + tmp;
    }
}
