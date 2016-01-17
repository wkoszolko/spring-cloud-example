package pl.koszolko.book.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.koszolko.book.catalog.model.Book;
import pl.koszolko.book.catalog.repository.BookRepository;

@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = "/catalog/books/", method = RequestMethod.GET)
    public Iterable<Book> books() {
        return repository.findAll();
    }

    @RequestMapping(value = "/catalog/books/{id}", method = RequestMethod.GET)
    public Book book(@PathVariable long id) {
        return repository.findOne(id);
    }
}
