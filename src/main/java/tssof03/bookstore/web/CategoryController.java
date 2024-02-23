package tssof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import tssof03.bookstore.domain.Category;
import tssof03.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository CategoryRepository;

    @GetMapping("/categorylist")

    public String categoryList(Model model) {
        model.addAttribute("categories", CategoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }


    @GetMapping("/addcategory")
    public String addNewCategory(Model model){
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/savenewcategory")
    public String saveNewCategory(@ModelAttribute Category category){
        CategoryRepository.save(category);
        return "redirect:/categorylist";
    }

}
