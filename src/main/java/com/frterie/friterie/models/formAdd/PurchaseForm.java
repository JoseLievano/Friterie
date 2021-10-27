package com.frterie.friterie.models.formAdd;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Validated
public class PurchaseForm {

    private Date date = new Date();

    private String state = "Cooking";

    @NotEmpty
    private List<Integer> productsID;

    @NotNull
    private Integer costumerID;


}
