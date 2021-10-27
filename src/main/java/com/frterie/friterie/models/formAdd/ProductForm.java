package com.frterie.friterie.models.formAdd;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class ProductForm {

    @NotBlank
    private String name;

    @Min(0)
    @NotNull
    private Double price;

    @NotEmpty
    private List<Integer> ingredientListIDs;

    @NotNull
    private Integer categoryID;

}
