package pl.lukaszdadura.service;

import org.springframework.stereotype.Component;
import pl.lukaszdadura.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getList() {
        return list;
    }

    @Override
    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(Long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        list.add(book);
        nextId++;
    }

    @Override
    public void editBook(Book book) {
        int index = 0;
        for (Book bookToFind : list) {
            if (bookToFind.getId().equals(book.getId())) {
                index = list.indexOf(bookToFind);
            }
        }
        list.set(index, book);
    }

    @Override
    public void removeBookById(Long id) {
        list.removeIf((el) -> el.getId() == id);
    }
}
