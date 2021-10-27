package com.frterie.friterie.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class IngredientMiniDTO {

    private Integer id;
    private String name;
    private Integer stock;
    private Double cost;

}
