package com.foodcrafter.foodcrafter.repository;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsAndBeveragesRepository extends JpaRepository<FoodsAndBeverages, Integer> {
    FoodsAndBeverages findOneFoodsAndBeverageById(int id);
}