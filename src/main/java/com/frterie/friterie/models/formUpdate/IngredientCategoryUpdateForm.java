package com.frterie.friterie.models.formUpdate;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class IngredientCategoryUpdateForm {

    private String name;

}
