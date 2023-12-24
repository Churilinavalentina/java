package edu.mipt.kozub.employee;

import edu.mipt.kozub.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee boss;
    private List<Employee> employee = new ArrayList<>();

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
        return employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoss(Employee boss) {
        addEmployee(boss);
        this.boss = boss;
    }

    public void addEmployee(Employee...employee) {
        for (Employee e: employee) {
            if(this.employee.contains(e)) return;
            e.getDepartment().removeEmployee(e);
            this.employee.add(e);
            e.setDepartment(this);
        }
    }

    public void removeEmployee(Employee employee) {
        if (!this.employee.contains(employee)) return;
        if(boss==employee) boss=null;
        this.employee.remove(employee);
        employee.setDepartment(null);
    }
    @Override
    public String toString(){
        String tmp = " with no boss";
        if(boss!=null)
            tmp = " , the boss is " + boss.getName();
        return this.name + tmp;
    }
}
