package com.frterie.friterie.models.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PurchaseMiniDTO {

    private Integer id;

    private Double price;

    private String state;

    private Date date;

    private List<ProductMiniDTO> productList;

    private CostumerMiniDTO costumer;

}
