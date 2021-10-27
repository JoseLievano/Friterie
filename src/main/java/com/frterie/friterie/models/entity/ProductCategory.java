package com.frterie.friterie.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @OneToMany (mappedBy = "category")
    @Column (nullable = true)
    private List<Product> products;

}
