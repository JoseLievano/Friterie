package com.frterie.friterie.models.formUpdate;

import com.frterie.friterie.models.dto.IngredientDTO;
import com.frterie.friterie.models.dto.ProductCategoryDTO;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class ProductUpdateForm {


    private String name;

    @Min(0)
    private Double price;

    private List<Integer> ingredientListIDs;

    @Min(0)
    private Integer categoryID;

}
