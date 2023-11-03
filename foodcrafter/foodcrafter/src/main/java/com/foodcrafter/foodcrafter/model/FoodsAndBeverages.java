package com.foodcrafter.foodcrafter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class FoodsAndBeverages {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private  Category category;

    private String name;

    private String ingredients;

    private double price;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getIngredients(){
        return ingredients;
    }

    public void setIngredients(String ingredients){
        this.ingredients=ingredients;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category=category;
    }

}
