package com.frterie.friterie.models.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class IngredientCategoryDTO {

    private Integer id;
    private String name;
    private List<IngredientMiniDTO> ingredientDTOS;

}
