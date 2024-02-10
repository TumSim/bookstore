package tssof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tssof03.bookstore.domain.Book;
import tssof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository BookRepository) {
		return (args) -> {
			// Your code...add some demo data to db

			Book book1 = new Book("tuomas", "Simoinen", 2008, "1995", 20.5);
			Book book2 = new Book("ida", "Hanninen", 2019, "1998", 1000.50);

			BookRepository.save(book1);
			BookRepository.save(book2);

		};
	}

}
