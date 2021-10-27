package com.frterie.friterie.models.dto;

import com.frterie.friterie.models.entity.Product;
import com.frterie.friterie.models.entity.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PurchaseDTO {

    private Integer id;

    private Double price;

    private String state;

    private Date date;

    private List<ProductMiniDTO> productList;

    private CostumerMiniDTO costumer;

    private WorkerMiniDTO worker;

}
