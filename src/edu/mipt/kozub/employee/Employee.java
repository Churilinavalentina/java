package edu.mipt.kozub.employee;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        if(name==null) name = "";
        this.name = name;
        this.department = department;
        this.department.getEmployee().add(this);
    }
    @Override
    public String toString(){
        if(department.getBoss()==null) return this.name + " работает в отделе "+ department.getName() + ", начальником которого является N/A";
        if (department.getBoss().getName() == this.name) {
            return this.name + " начальник отдела " + department.getName();
        }
        return this.name + " работает в отделе "+ department.getName() + ", начальником которого является "+ department.getBoss().getName();
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department){
        if(this.department != null){
            this.department.removeEmployee((this));
        }
        this.department = department;
        if(department!=null) this.department.addEmployee(this);
    }
}
