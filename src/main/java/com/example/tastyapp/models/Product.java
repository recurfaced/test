package com.example.tastyapp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "nameBurger")
    private String nameBurger;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "imagePath")
    private String imagePath;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private List<NutritionalValue> nutritionalValues = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private List<Ingredient> ingredients = new ArrayList<>();
    public void addIngredientToProduct(Ingredient ingredient) {
        ingredient.setProduct(this);
        ingredients.add(ingredient);

    }

    public void addNutritionalValuesToProduct(NutritionalValue nutritionalValue){
        nutritionalValue.setProduct(this);
        nutritionalValues.add(nutritionalValue);
    }
}
