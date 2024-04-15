package edu.mfti.project.controller;

import edu.mfti.project.repository.Book;
import edu.mfti.project.repository.Receipts;
import edu.mfti.project.repository.User;
import edu.mfti.project.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> listBool = libraryService.listAllBook();
        List<User> listUser = libraryService.listAllUser();
        List<Receipts> listReceipts = libraryService.listAllReceipts();
        model.addAttribute("book", listBool);
        model.addAttribute("user", listUser);
        model.addAttribute("receipts", listReceipts);
        return "index";
    }

    @RequestMapping(value="/new_book", method=RequestMethod.GET)
    public String newBookForm(Map<String, Object> model) {
        Book book = new Book();
        model.put("book", book);
        return "new_book";
    }

    @RequestMapping(value="/save_book", method=RequestMethod.POST)
    public String saveBook(@RequestParam Integer id, @RequestParam String name, @RequestParam String author) {
        Book book = new Book(id, name, author);
        libraryService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit_book")
    public String editBookForm(@RequestParam Integer id, Map<String, Object> model) {
        Book book = libraryService.getBook(id);
        model.put("book", book);
        return "edit_book";
    }

    @GetMapping("/delete_book")
    public String deleteBookForm(@RequestParam Integer id) {
        libraryService.deleteBook(id);
        return "redirect:/";
    }

    @RequestMapping(value="/new_user", method=RequestMethod.GET)
    public String newUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }

    @RequestMapping(value="/save_user", method=RequestMethod.POST)
    public String saveUser(@RequestParam Integer id, @RequestParam String name) {
        User user = new User(id, name);
        libraryService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit_user")
    public String editUserForm(@RequestParam Integer id, Map<String, Object> model) {
        User user = libraryService.getUser(id);
        model.put("user", user);
        return "edit_user";
    }

    @GetMapping("/delete_user")
    public String deleteUserForm(@RequestParam Integer id) {
        libraryService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value="/new_receipts", method=RequestMethod.GET)
    public String newReceiptsForm(Map<String, Object> model) {
        Receipts receipts = new Receipts();
        model.put("receipts", receipts);
        return "new_receipts";
    }

    @RequestMapping(value="/save_receipts", method=RequestMethod.POST)
    public String saveReceipts(@RequestParam Integer id, @RequestParam Integer book_id,
                               @RequestParam Integer user_id, @RequestParam String open_dt, @RequestParam String close_dt) {
        Receipts receipts = new Receipts(id, book_id, user_id, open_dt, close_dt);
        libraryService.saveReceipts(receipts);
        return "redirect:/";
    }

    @GetMapping("/edit_receipts")
    public String editReceiptsForm(@RequestParam Integer id, Map<String, Object> model) {
        Receipts receipts = libraryService.getReceipts(id);
        model.put("receipts", receipts);
        return "edit_receipts";
    }

    @GetMapping("/delete_receipts")
    public String deleteUReceiptsForm(@RequestParam Integer id) {
        libraryService.deleteReceipts(id);
        return "redirect:/";
    }
}