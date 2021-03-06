package pl.lukaszdadura.service;

import pl.lukaszdadura.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();

    void setList(List<Book> list);

    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public void addBook(Book book);

    public void editBook(Book book);

    public void removeBookById(Long id);

}
