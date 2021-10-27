package com.frterie.friterie.models.formUpdate;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class IngredientUpdateForm {

    private String name;

    @Min(0)
    private Integer stock;

    @Min(0)
    private Double cost;

    @Min(0)
    private Integer categoryID;

}
