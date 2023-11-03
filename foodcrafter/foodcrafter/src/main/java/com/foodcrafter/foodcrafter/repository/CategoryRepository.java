package com.foodcrafter.foodcrafter.repository;

import com.foodcrafter.foodcrafter.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
