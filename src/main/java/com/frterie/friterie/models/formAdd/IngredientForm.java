package com.frterie.friterie.models.formAdd;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class IngredientForm {

    @NotBlank
    private String name;

    @Min(0)
    @NotNull
    private Integer stock;

    @Min(0)
    @NotNull
    private Double cost;

    @Min(0)
    @NotNull
    private Integer categoryID;

}
