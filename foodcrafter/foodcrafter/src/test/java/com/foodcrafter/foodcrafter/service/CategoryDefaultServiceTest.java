package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.Category;
import com.foodcrafter.foodcrafter.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDefaultServiceTest {

    private CategoryDefaultService categoryDefaultService;
    private CategoryRepository categoryRepository;



    @BeforeEach
    void setUp() {
        categoryRepository= Mockito.mock(CategoryRepository.class);
        categoryDefaultService=new CategoryDefaultService(categoryRepository);
    }

    @Test
    public void testSaveCategory_Succes(){
        Category category=new Category();
        category.setName("Sutlu Tatli");
        category.setPriority(1);

        Mockito.when(categoryRepository.save(category)).thenReturn(category);
        Category result= categoryDefaultService.saveCategory(category);
        assertEquals(result,category);
    }
    /*
     public Category updateCategory(Category category, int id) {
        Category existingCategory= categoryRepository.findById(id).orElse(null);
        if(existingCategory==null){
            return null;
        }
        existingCategory.setName(category.getName());
        existingCategory.setPriority(category.getPriority());

        categoryRepository.save(existingCategory);

        return existingCategory;
    }
     */
    @Test
    public void testUpdateCategoryMethod(){
        Category category=new Category();

    }
}