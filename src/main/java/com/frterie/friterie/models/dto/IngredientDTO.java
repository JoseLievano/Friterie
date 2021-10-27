package com.frterie.friterie.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class IngredientDTO {

    private Integer id;
    private String name;
    private Integer stock;
    private Double cost;
    private IngredientCategoryMiniDTO category;

}
