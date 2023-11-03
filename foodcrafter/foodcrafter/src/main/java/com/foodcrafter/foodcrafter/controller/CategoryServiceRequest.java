package com.foodcrafter.foodcrafter.controller;

import com.foodcrafter.foodcrafter.model.Category;

public record CategoryServiceRequest(
        String name,
        int priority

) {
    Category toServiceRequest(){
        Category category=new Category();
        category.setName(name);
        category.setPriority(priority);
        return category;
    }
}
