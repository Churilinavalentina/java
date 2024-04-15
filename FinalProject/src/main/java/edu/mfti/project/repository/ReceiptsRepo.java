package edu.mfti.project.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceiptsRepo extends CrudRepository<Receipts, Integer> {
    List<Book> findAllByBookId(String book_id);
}
