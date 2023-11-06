package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.Category;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CategoryService {

    Category saveCategory(Category category);

    Category updateCategory(Category category,int id);

    boolean deleteCategory(int id);

    List<Category> listCategory();

    Category findCategoryById(int id);
}
