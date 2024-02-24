package tssof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tssof03.bookstore.domain.Book;
import tssof03.bookstore.domain.BookRepository;
import tssof03.bookstore.domain.CategoryRepository;



@Controller

public class BookController {
    
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/booklist")

    public String firstPage(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; //booklist.html
    }

    @GetMapping("/add")

    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; //addbook.html
    }

    @PostMapping("/savebook")

    public String saveBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)

    public String deleteBook(@PathVariable("id") Long bookId){
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";

    }

    @RequestMapping(value = "/editbook/{id}")

    public String editBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("id", bookRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook"; //editbook.html
    }

    @PostMapping("/saveagain")

    public String saveAgain(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}
