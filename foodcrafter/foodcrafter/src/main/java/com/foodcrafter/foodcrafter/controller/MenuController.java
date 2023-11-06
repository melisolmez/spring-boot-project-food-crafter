package com.foodcrafter.foodcrafter.controller;

import com.foodcrafter.foodcrafter.model.FoodsAndBeverages;
import com.foodcrafter.foodcrafter.service.FoodsAndBeverageDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuController {
    private final FoodsAndBeverageDefaultService foodsAndBeverageService;
    @Autowired
    public MenuController(FoodsAndBeverageDefaultService foodsAndBeverageService) {
        this.foodsAndBeverageService = foodsAndBeverageService;
    }

    @GetMapping
    public ResponseEntity<List<FoodsAndBeverages>> foodsAndBeveragesList(){
        List<FoodsAndBeverages> existLists=foodsAndBeverageService.foodsAndBeveragesList();
         if(existLists!=null){
             return new ResponseEntity<>(existLists,HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodsAndBeverages> getOneFoodsAndBeverage(@PathVariable int id){
        FoodsAndBeverages existFood= foodsAndBeverageService.getFoodsAndBeverageById(id);
        if(existFood!=null){
            return new ResponseEntity<>(existFood,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
