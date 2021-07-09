package pl.lukaszdadura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lukaszdadura.model.Book;
import pl.lukaszdadura.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void editBook(@RequestBody Book book) {
        bookService.editBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeBook(@PathVariable Long id) {
        bookService.removeBookById(id);
    }
}
