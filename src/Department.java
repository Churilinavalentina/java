import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee boss;
    private List<Employee> employee = new ArrayList<>();

    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
        boss.setDepartment(this);
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
        this.boss = boss;
    }

    public void setEmployee(Employee...employee) {
        for (Employee e: employee) this.employee.add(e);
    }
}
