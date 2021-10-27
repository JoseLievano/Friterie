package com.frterie.friterie.models.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductDTO {

    private Integer id;
    private String name;
    private Double price;
    private List<IngredientMiniDTO> ingredientMiniDTOs;
    private ProductCategoryMiniDTO category;

}
