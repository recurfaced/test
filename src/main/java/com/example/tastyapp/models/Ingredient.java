package com.example.tastyapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "VealCutlet")
    // котлета
    private String VealCutlet;

    @Column(name = "Mayonnaise")
    private String Mayonnaise;

    @Column(name = "LettuceLeaf")
    // салат
    private String LettuceLeaf;

    @Column(name = "AmericanMustard")
    // горчица гринго
    private String AmericanMustard;

    @Column(name = "RedOnion")
    // красный лук
    private String RedOnion;

    @Column(name = "Pickles")
    // огурцы
    private String Pickles;

    @Column(name = "BarbecueSauce")
    // соус барбекю
    private String BarbecueSauce;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ingredient_nutritional_value",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "nutritional_value_id")
    )
    private List<NutritionalValue> nutritionalValues = new ArrayList<>();

    public void addNutritionalValue(NutritionalValue nutritionalValue) {
        nutritionalValues.add(nutritionalValue);
    }
}
