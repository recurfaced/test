package com.example.tastyapp.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionalValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // калории
    @Column(name = "calories")
    private Integer calories;

    // жиры
    @Column(name = "fats")
    private Integer fats;

    // белки
    @Column(name = "squirrels")
    private Integer squirrels;

    // углеводы
    @Column(name = "carbs")
    private Integer carbs;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
}
