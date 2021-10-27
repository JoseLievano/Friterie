package com.frterie.friterie.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Double price;

    @ManyToOne
    private ProductCategory category;

    @ManyToMany (mappedBy = "products")
    private Set<Ingredient> ingredients;

    @ManyToMany (mappedBy = "productList")
    @Column (nullable = true)
    private List<Purchase> inOrders;



}
