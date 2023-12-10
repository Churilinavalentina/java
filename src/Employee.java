public class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString(){
        if (department.boss.name == this.name) {
            return this.name + " начальник отдела " + department.name;
        }
        return this.name + " работает в отделе "+ department.name + ", начальником которого является "+ department.boss.name;
    }

    public void setDepartment(Department department){
        this.department = department;
        department.employee.add(this);
    }

    public static void main(String[] args) {
        //1.2.4
        Department department1 = new Department("IT", null);
        Employee people1 = new Employee("Петров", department1);
        Employee people2 = new Employee("Козлов", department1);
        Employee people3 = new Employee("Сидоров", department1);
        department1.boss = people2;

        people1.setDepartment(department1);
        people2.setDepartment(department1);
        people3.setDepartment(department1);

        System.out.println(people1.toString());
        System.out.println(people2.toString());
        System.out.println(people3.toString());

    }
}
