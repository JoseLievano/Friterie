package com.frterie.friterie.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer stock;

    @Column
    private Double cost;

    @ManyToOne
    private IngredientCategory category;

    @ManyToMany (fetch = FetchType.EAGER)
    private List<Product> products;

    public void reduceStock(Integer combien){

        this.stock -= combien;

    }

    public void addProduct(Product product){
        if (this.products == null){
            this.products = new ArrayList<>();
            this.products.add(product);
            System.out.println("primero");
        }else {
            this.products.add(product);
            System.out.println("otro");
        }
    }


    public void deleteProduct(Product product){
        if (this.products == null){
            this.products = new ArrayList<>();
            this.products.stream().forEach(
                    productInside -> this.products.remove(productInside)
            );
        }else {
            this.products.remove(product);
        }
    }

}
