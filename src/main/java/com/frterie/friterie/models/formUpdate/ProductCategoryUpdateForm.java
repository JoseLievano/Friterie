package com.frterie.friterie.models.formUpdate;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ProductCategoryUpdateForm {

    private String name;

}
