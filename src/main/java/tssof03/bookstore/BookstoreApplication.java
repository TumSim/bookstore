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
import tssof03.bookstore.domain.User;
import tssof03.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository BookRepository, CategoryRepository CategoryRepository, UserRepository userRepository) {
		return (args) -> {
			// added some demo data to db

			log.info("Demo category data");
			Category category1 = new Category("Scifi");
			Category category2 = new Category("Comic");
			Category category3 = new Category("Fantasy");


			log.info("couple books");
			Book book1 = new Book("test1", "Book1", 2008, "1995", 20.5, category1);
			Book book2 = new Book("test2", "book2", 2019, "1998", 1000.50, category2);

			User user1 = new User("user", "$2a$10$U.EZt/m7.LVgrJQS5gjm0eYviU4Pm1C7aLnn57sOhw/gDLtHuz3Zu", "user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$PDGq.tZ/cV.edc7m.VvWXOmj0YWtoguKFtIYujNVBPVVRmH42oi8G", "admin@admin.com", "ADMIN");



			log.info("fetch");
			userRepository.save(user1);
			userRepository.save(user2);
			CategoryRepository.save(category1);
			CategoryRepository.save(category2);
			CategoryRepository.save(category3);
			BookRepository.save(book1);
			BookRepository.save(book2);

		};
	}

}
