package ru.mipt.edu.kozub.jbdc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    List<Department> findAllByName(String name);
}
