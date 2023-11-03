package com.foodcrafter.foodcrafter.controller;

import com.foodcrafter.foodcrafter.model.Category;
import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;

public record FoodsServiceRequest(
        String name,
        String ingredients,
        double price,
        int categoryId

) {
    FoodsAndBeverages toServiceRequest(){

        Category category=new Category();
        category.setId(categoryId);

        FoodsAndBeverages foodsAndBeverages=new FoodsAndBeverages();
        foodsAndBeverages.setName(name);
        foodsAndBeverages.setPrice(price);
        foodsAndBeverages.setIngredients(ingredients);
        foodsAndBeverages.setCategory(category);

        return foodsAndBeverages;

    }
}
