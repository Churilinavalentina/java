package edu.mfti.project.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    List<Book> findAllByName(String name);
}