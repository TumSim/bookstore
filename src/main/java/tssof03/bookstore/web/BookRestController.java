package tssof03.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import tssof03.bookstore.domain.Book;
import tssof03.bookstore.domain.BookRepository;

@Controller
@CrossOrigin

public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
        public @ResponseBody List<Book> getBooksRest(){
            return (List<Book>) bookRepository.findAll();
        }

    @GetMapping("/books/{id}")
     public @ResponseBody Optional<Book> getOneBook (@PathVariable("id") Long bookId){
        return bookRepository.findById(bookId);
     }
}
