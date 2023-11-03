package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface FoodsAndBeverageService {
    FoodsAndBeverages saveFoodsBeverages(FoodsAndBeverages foodsAndBeverages);

    FoodsAndBeverages updateFoodsBeverages(FoodsAndBeverages foodsAndBeverages,int id);

    boolean deleteFoodsBeveragesById(int id);

    List<FoodsAndBeverages> foodsAndBeveragesList();
}
