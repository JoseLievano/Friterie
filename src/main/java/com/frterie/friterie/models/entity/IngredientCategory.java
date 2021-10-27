package com.frterie.friterie.models.entity;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientCategory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @OneToMany (mappedBy = "category")
    @Column (nullable = true)
    private List<Ingredient> ingredientsList;

}
