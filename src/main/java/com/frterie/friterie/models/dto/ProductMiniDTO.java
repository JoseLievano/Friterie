package com.frterie.friterie.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductMiniDTO {

    private Integer id;
    private String name;
    private Double price;

}
