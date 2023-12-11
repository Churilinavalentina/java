public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;

    }
    @Override
    public String toString(){
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
        this.department = department;
        department.getEmployee().add(this);
    }

    public static void main(String[] args) {
        Employee people1 = new Employee("Петров", null);
        Department department1 = new Department("IT", people1);

        System.out.println(people1.toString());

    }
}
