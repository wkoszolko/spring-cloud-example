package pl.koszolko.book.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import pl.koszolko.book.review.model.Review;
import pl.koszolko.book.review.repository.ReviewRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class BookReviewApplication implements CommandLineRunner {

	@Autowired
	private ReviewRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookReviewApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		repository.save(
				Review.builder()
						.id(1L)
						.bookId(1L)
						.reviewText("I sure wish I had this book ten years ago. Some might think that I don’t need any Java books, " +
								"but I need this one.")
						.build()
		);

		repository.save(
				Review.builder()
						.id(2L)
						.bookId(1L)
						.reviewText("An excellent book, crammed with good advice on using the Java programming language and " +
								"object-oriented programming in general.")
						.build()
		);

		repository.save(
				Review.builder()
						.id(3L)
						.bookId(1L)
						.reviewText("“10/10—anyone aspiring to write good Java code that others will appreciate reading and " +
								"maintaining should be required to own a copy of this book.")
						.build()
		);

		repository.save(
				Review.builder()
						.id(4L)
						.bookId(2L)
						.reviewText("The best Java book yet written.... Really great; very readable and eminently useful. " +
								"I can’t say enough good things about this book.")
						.build()
		);

		repository.save(
				Review.builder()
						.id(5L)
						.bookId(2L)
						.reviewText("This is a truly excellent book done by the guy who designed several of the better " +
								"recent Java platform APIs (including the Collections API).")
						.build()
		);
	}
}
