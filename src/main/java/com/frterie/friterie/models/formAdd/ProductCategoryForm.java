package com.frterie.friterie.models.formAdd;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Validated
public class ProductCategoryForm {

    @NotBlank
    private String name;

}
