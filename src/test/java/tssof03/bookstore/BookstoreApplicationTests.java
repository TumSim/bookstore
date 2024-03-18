package tssof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tssof03.bookstore.web.BookController;
import tssof03.bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

@Autowired
BookController bookController;

@Autowired
CategoryController categoryController;


	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoadsBook() throws Exception{
		assertThat(bookController).isNotNull();
	}

	@Test
	public void contextLoadsCategory() throws Exception{
		assertThat(categoryController).isNotNull();
	}

}
