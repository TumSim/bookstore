package tssof03.bookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tssof03.bookstore.domain.Book;
import tssof03.bookstore.domain.BookRepository;
import tssof03.bookstore.domain.Category;
import tssof03.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookRepositoryTest {

   @Autowired
   private BookRepository bookRepository;

   @Autowired
   private CategoryRepository categoryRepository;

   @Test
   public void newBook(){
    Category category = categoryRepository.findByName("Scifi");
    assertThat(category).isNotNull();
    
    Book book = new Book("testtest", "TuomasTest", 2002, "222-EEE", 20.34, category);

    bookRepository.save(book);
    assertThat(book.getId()).isNotNull();
   }

   @Test
   public void deleteBook(){
    Category category = categoryRepository.findByName("Scifi");
    assertThat(category).isNotNull();
    
    Book book = new Book("testtest", "TuomasTest", 2002, "222-EEE", 20.34, category);

    bookRepository.save(book);
    
    bookRepository.delete(book);

    assertThat(bookRepository.findById(book.getId())).isEmpty();
   }
   @Test
   public void findAuthor(){
    List<Book> book = bookRepository.findByTitle("test1");

    assertThat(book).hasSize(1);
    assertThat(book.get(0).getAuthor()).isEqualTo("Book1");
   }

}
