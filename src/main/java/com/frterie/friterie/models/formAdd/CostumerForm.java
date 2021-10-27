package com.frterie.friterie.models.formAdd;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class CostumerForm {

    @NotBlank
    @Length(min = 4, max = 12)
    private String name;

    @NotBlank
    @Length(min = 4, max = 12)
    private String username;

    @NotBlank
    @Min(8)
    private String password;



}
