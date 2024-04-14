package edu.mfti.project.controller;

import edu.mfti.project.repository.Book;
import edu.mfti.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> listBool = bookService.listAll();
        model.addAttribute("book", listBool);
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
        System.out.println(book);
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping("/edit_book")
    public String editBookForm(Map<String, Object> model, @RequestParam Integer id) {
        System.out.println("ID: "+id);
        Book book = bookService.get(id);
        System.out.println(book);
        model.put("book", book);
        return "edit_book";
    }

    @GetMapping("/delete_book")
    public String deleteBookForm(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/";
    }
}