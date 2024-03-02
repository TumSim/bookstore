package tssof03.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tssof03.bookstore.domain.Category;
import tssof03.bookstore.domain.CategoryRepository;

@Controller
@CrossOrigin

public class CategoryRestController {


    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
        public @ResponseBody List<Category> getAllCategoriesRest(){
            return (List<Category>) categoryRepository.findAll();
        }

    @PostMapping("/categories")
        public @ResponseBody Category saveNewCategoryRest(@RequestBody Category category){
            return categoryRepository.save(category);
        }
}
