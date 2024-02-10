package tssof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tssof03.bookstore.domain.BookRepository;



@Controller

public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/booklist")

    public String firstPage(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; //booklist.html
    }
}
