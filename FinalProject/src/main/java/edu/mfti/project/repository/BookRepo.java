package edu.mfti.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepo  extends CrudRepository<Book, Integer> {
    List<Book> findAllByName(String name);
}
