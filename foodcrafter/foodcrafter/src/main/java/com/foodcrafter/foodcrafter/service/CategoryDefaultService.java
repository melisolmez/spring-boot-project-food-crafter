package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.Category;
import com.foodcrafter.foodcrafter.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDefaultService implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDefaultService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    @Override
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

    @Override
    public boolean deleteCategory(int id) {
        Category existCategory= categoryRepository.findById(id).orElse(null);
        if(existCategory!=null){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findOneCategoryById(id);
    }

}
