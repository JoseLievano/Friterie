package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.IngredientDTO;
import com.frterie.friterie.models.dto.IngredientMiniDTO;
import com.frterie.friterie.models.formAdd.IngredientForm;
import com.frterie.friterie.models.formUpdate.IngredientUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController extends AbstractCrudController <IngredientDTO, IngredientMiniDTO, IngredientForm, IngredientUpdateForm, Integer>{

    protected IngredientController(DefaultService<IngredientDTO, IngredientMiniDTO, IngredientForm, IngredientUpdateForm, Integer> service){
        super(service);
    }

}
