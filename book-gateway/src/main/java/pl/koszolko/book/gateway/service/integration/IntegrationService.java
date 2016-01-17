package pl.koszolko.book.gateway.service.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koszolko.book.gateway.model.BookDetails;
import pl.koszolko.book.gateway.service.catalog.Book;
import pl.koszolko.book.gateway.service.catalog.CatalogService;
import pl.koszolko.book.gateway.service.review.Review;
import pl.koszolko.book.gateway.service.review.ReviewService;
import rx.Observable;

import java.util.List;

@Component
public class IntegrationService {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CatalogService catalogService;

    public Observable<BookDetails> getBookDetails(long bookId) {
        return Observable.zip(
                catalogService.getBook(bookId),
                reviewService.getReviewsBy(bookId),
                this::buildBookDetails
        );
    }

    private BookDetails buildBookDetails(final Book book, final List<Review> reviews) {
        BookDetails bookDetails = new BookDetails();
        bookDetails.setId(book.getId());
        bookDetails.setTitle(book.getTitle());
        bookDetails.setDescription(book.getDescription());
        bookDetails.setReviews(reviews);
        return bookDetails;
    }
}
