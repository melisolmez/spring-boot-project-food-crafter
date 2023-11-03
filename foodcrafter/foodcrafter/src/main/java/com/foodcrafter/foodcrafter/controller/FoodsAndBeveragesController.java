package com.foodcrafter.foodcrafter.controller;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import com.foodcrafter.foodcrafter.service.FoodsAndBeverageDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foods")
public class FoodsAndBeveragesController {
    private final FoodsAndBeverageDefaultService foodsAndBeverageService;
    @Autowired
    public FoodsAndBeveragesController(FoodsAndBeverageDefaultService foodsAndBeverageService){
        this.foodsAndBeverageService=foodsAndBeverageService;
    }

    @PostMapping
    public ResponseEntity<FoodsAndBeverages> saveFoods(@RequestBody FoodsServiceRequest foodsAndBeverages){
        if(foodsAndBeverageService.saveFoodsBeverages(foodsAndBeverages.toServiceRequest())!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FoodsAndBeverages> updateFoods(@RequestBody FoodsServiceRequest foodsAndBeverages,@PathVariable int id){
        if(foodsAndBeverageService.updateFoodsBeverages(foodsAndBeverages.toServiceRequest(),id)!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteFoodsBeverages(@PathVariable int id){
        if(foodsAndBeverageService.deleteFoodsBeveragesById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
