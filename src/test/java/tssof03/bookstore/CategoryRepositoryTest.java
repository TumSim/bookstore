package tssof03.bookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tssof03.bookstore.domain.Category;
import tssof03.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void newCategory(){
        Category category = new Category("Test");

        categoryRepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void deleteCategory(){
        Category category = new Category("Test");

        categoryRepository.save(category);

        categoryRepository.delete(category);

        assertThat(categoryRepository.findById(category.getCategoryid())).isEmpty();
    }

    @Test
    public void findCategory(){
        Category foundCategory = categoryRepository.findByName("Scifi");

        assertThat(foundCategory).isNotNull();
        assertThat(foundCategory.getName()).isEqualTo("Scifi");

        
    }
}
