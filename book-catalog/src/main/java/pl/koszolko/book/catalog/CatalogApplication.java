package pl.koszolko.book.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import pl.koszolko.book.catalog.model.Book;
import pl.koszolko.book.catalog.repository.BookRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class CatalogApplication implements CommandLineRunner {

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		repository.save(
				Book.builder()
						.id(1L)
						.title("Head First Java")
						.description("Learning a complex new language is no easy task especially when it s an " +
								"object-oriented computer programming language like Java")
						.build()
		);

		repository.save(
				Book.builder()
						.id(2L)
						.title("Effective Java")
						.description("Are you looking for a deeper understanding of the Java™ programming language so " +
								"that you can write code that is clearer, more correct, more robust, and more reusable")
						.build()
		);
	}
}
