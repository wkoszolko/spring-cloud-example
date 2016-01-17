package pl.koszolko.book.review.repository;


import org.springframework.data.repository.CrudRepository;
import pl.koszolko.book.review.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Iterable<Review> findByBookId(Long bookId);
}
