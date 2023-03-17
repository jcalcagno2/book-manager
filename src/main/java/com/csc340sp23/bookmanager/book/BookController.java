package com.csc340sp23.bookmanager.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author josephcalcagno  
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService BookService;

    @GetMapping("/all")
    public String getBooks(Model model) {
        model.addAttribute("bookList", BookService.getAllBooks());
        return "book/list-book"; 

    }
      @PostMapping("/create")
    public String createBook(Book book) {

        BookService.saveBook(book);
        return "redirect:/book/all";  
    }
    
     @GetMapping("/id={bookId}")
    public String getBook(@PathVariable long bookId, Model model) {
        model.addAttribute("Book", BookService.getBook(bookId));
        return "book/book-detail";
    }
    
     @GetMapping("/delete/id={bookId}")
    public String deleteBook(@PathVariable long bookId, Model model) {
        BookService.deleteBook(bookId);
        return "redirect:/book/all";
    } 
    
    @PostMapping("/update")
    public String upateBook(Book book) {
        BookService.saveBook(book);
        return "redirect:/book/all";
    }
    
     @GetMapping("/new-book")
    public String newBookForm(Model model) {  
        return "book/new-book";
    }
    
     @GetMapping("/update/id={bookId}")
    public String updateBookForm(@PathVariable long bookId, Model model) {
        model.addAttribute("Book", BookService.getBook(bookId));
        return "book/update-book";
    }

}
