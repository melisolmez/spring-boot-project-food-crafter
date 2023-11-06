package com.foodcrafter.foodcrafter.controller;

import com.foodcrafter.foodcrafter.model.Category;
import com.foodcrafter.foodcrafter.service.CategoryDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
   private final CategoryDefaultService categoryService;
   @Autowired
   public CategoryController(CategoryDefaultService categoryService) {
      this.categoryService = categoryService;
   }

   @PostMapping
   public ResponseEntity<Category> addCategory(@RequestBody CategoryServiceRequest category){
      if(categoryService.saveCategory(category.toServiceRequest())!=null){
         return new ResponseEntity<>(HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Category> updateCategory(@RequestBody CategoryServiceRequest category,@PathVariable int id){
      if(categoryService.updateCategory(category.toServiceRequest(),id)!=null){
         return new ResponseEntity<>(HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public ResponseEntity<?> deleteCategoryById(@PathVariable int id){
       if(categoryService.deleteCategory(id)){
          return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @GetMapping
   public ResponseEntity<List<Category>> getAllCategory(){
      List<Category> existCategories=categoryService.listCategory();
      if(existCategories!=null){
         return new ResponseEntity<>(existCategories,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Category> getCategoryById(@PathVariable int id){
      Category existCategory=categoryService.findCategoryById(id);
      if(existCategory!=null){
         return new ResponseEntity<>(existCategory,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}
