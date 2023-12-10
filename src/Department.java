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
}
