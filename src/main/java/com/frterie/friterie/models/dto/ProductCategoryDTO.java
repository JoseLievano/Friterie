package com.frterie.friterie.models.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductCategoryDTO {

    private Integer id;
    private String name;
    private List<ProductMiniDTO> productDTOS;

}
