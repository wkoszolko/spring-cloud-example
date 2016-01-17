package pl.koszolko.book.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.koszolko.book.review.model.Review;
import pl.koszolko.book.review.repository.ReviewRepository;

@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository repository;

    @RequestMapping(value = "/reviews/", method = RequestMethod.GET)
    public Iterable<Review> reviews() {
        return repository.findAll();
    }

    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
    public Review review(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/reviewsFor/{bookId}", method = RequestMethod.GET)
    public Iterable<Review> reviewFor(@PathVariable Long bookId) {
        return repository.findByBookId(bookId);
    }
}
