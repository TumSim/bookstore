package tssof03.bookstore;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tssof03.bookstore.domain.Book;
import tssof03.bookstore.domain.BookRepository;
import tssof03.bookstore.domain.Category;
import tssof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository BookRepository, CategoryRepository CategoryRepository) {
		return (args) -> {
			// added some demo data to db

			log.info("couple books");
			Book book1 = new Book("test1", "Book1", 2008, "1995", 20.5);
			Book book2 = new Book("test2", "book2", 2019, "1998", 1000.50);

			log.info("Demo category data");
			Category category1 = new Category("Scifi");
			Category category2 = new Category("Comic");
			Category category3 = new Category("Fantasy");


			log.info("fetch");
			BookRepository.save(book1);
			BookRepository.save(book2);
			CategoryRepository.save(category1);
			CategoryRepository.save(category2);
			CategoryRepository.save(category3);


		};
	}

}
