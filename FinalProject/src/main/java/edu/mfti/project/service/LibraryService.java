package edu.mfti.project.service;

import java.util.List;
import java.util.NoSuchElementException;

import edu.mfti.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LibraryService {
    @Autowired
    BookRepo repoBook;

    @Autowired
    UserRepo repoUser;

    @Autowired
    ReceiptsRepo repoReceipts;

    public void saveBook(Book book) {
        repoBook.save(book);
    }

    public List<Book> listAllBook() {
        return (List<Book>) repoBook.findAll();
    }

    public Book getBook(Integer id) {
        return repoBook.findById(id).get();
    }

    public void deleteBook(Integer id) {
        repoBook.deleteById(id);
    }

    public void saveUser(User user) {
        repoUser.save(user);
    }

    public List<User> listAllUser() {
        return (List<User>) repoUser.findAll();
    }

    public User getUser(Integer id) {
        return repoUser.findById(id).get();
    }

    public void deleteUser(Integer id) {
        repoUser.deleteById(id);
    }

    public void saveReceipts(Receipts receipts) {

        System.out.println(repoUser.findById(receipts.book_id));
        if (repoUser.findById(receipts.book_id).isEmpty()) {
            throw new NoSuchElementException("Такой книги не существует");
        } else if (repoUser.findById(receipts.user_id).isEmpty()) {
            throw new NoSuchElementException("Такого пользователя не существует");
        } else {
            repoReceipts.save(receipts);
        }
    }

    public List<Receipts> listAllReceipts() {
        return (List<Receipts>) repoReceipts.findAll();
    }

    public Receipts getReceipts(Integer id) {
        return repoReceipts.findById(id).get();
    }

    public void deleteReceipts(Integer id) {
        repoReceipts.deleteById(id);
    }


}