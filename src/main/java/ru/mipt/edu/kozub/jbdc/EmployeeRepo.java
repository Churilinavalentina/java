package ru.mipt.edu.kozub.jbdc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepo extends Repository<Employee, Integer> {
    List<Employee> findAllByName(String name);

    @Query(nativeQuery = true, value = "select e.id, e.name, d.name as depName from employee as e left join department as d on e.DepartmentID = d.id")
    List<Employee> findAll();
}
