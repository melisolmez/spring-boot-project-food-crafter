package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public interface FoodsAndBeverageService {
    FoodsAndBeverages saveFoodsBeverages(FoodsAndBeverages foodsAndBeverages);

    FoodsAndBeverages updateFoodsBeverages(FoodsAndBeverages foodsAndBeverages,int id);

    boolean deleteFoodsBeveragesById(int id);

    List<FoodsAndBeverages> foodsAndBeveragesList();

    FoodsAndBeverages getFoodsAndBeverageById(int id);
}
