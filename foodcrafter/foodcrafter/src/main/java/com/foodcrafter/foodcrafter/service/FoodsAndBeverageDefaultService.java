package com.foodcrafter.foodcrafter.service;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import com.foodcrafter.foodcrafter.repository.FoodsAndBeveragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodsAndBeverageDefaultService implements FoodsAndBeverageService {
    private final FoodsAndBeveragesRepository repository;

    @Autowired
    public FoodsAndBeverageDefaultService(FoodsAndBeveragesRepository repository) {
        this.repository = repository;
    }
    @Override
    public FoodsAndBeverages saveFoodsBeverages(FoodsAndBeverages foodsAndBeverages) {
        return repository.save(foodsAndBeverages);

    }
    @Override
    public FoodsAndBeverages updateFoodsBeverages(FoodsAndBeverages foodsAndBeverages, int id) {
        FoodsAndBeverages existingFoods = repository.findById(id).orElse(null);

        assert existingFoods != null;
        existingFoods.setName(foodsAndBeverages.getName());
        existingFoods.setPrice(foodsAndBeverages.getPrice());
        existingFoods.setIngredients(foodsAndBeverages.getIngredients());

        repository.save(existingFoods);

        return existingFoods;
    }

    @Override
    public boolean deleteFoodsBeveragesById(int id) {
        FoodsAndBeverages existFoodsAndBeverage= repository.findById(id).orElse(null);
        if(existFoodsAndBeverage!=null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<FoodsAndBeverages> foodsAndBeveragesList() {
        return repository.findAll();
    }

}
