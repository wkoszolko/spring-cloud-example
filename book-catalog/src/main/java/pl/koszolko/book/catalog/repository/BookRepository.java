package pl.koszolko.book.catalog.repository;

import org.springframework.data.repository.CrudRepository;
import pl.koszolko.book.catalog.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
