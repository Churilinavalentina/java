package ru.mipt.edu.kozub.jbdc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);

    @Query(value = "select e.id, e.name, d.name from Employee as e left join Department as d on e.DepartmentID = d.id")
    List<Employee> join();
}
