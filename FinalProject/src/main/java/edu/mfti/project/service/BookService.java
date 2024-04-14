package edu.mfti.project.service;

import java.util.List;

import edu.mfti.project.repository.Book;
import edu.mfti.project.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepo repo;

    public void save(Book book) {
        System.out.println(book);
        repo.save(book);
    }

    public List<Book> listAll() {
        return (List<Book>) repo.findAll();
    }

    public Book get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}