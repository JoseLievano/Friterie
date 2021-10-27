package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.IngredientCategoryDTO;
import com.frterie.friterie.models.dto.IngredientCategoryMiniDTO;
import com.frterie.friterie.models.formAdd.IngredientCategoryForm;
import com.frterie.friterie.models.formUpdate.IngredientCategoryUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient-category")
public class IngredientCategoryController extends AbstractCrudController <IngredientCategoryDTO, IngredientCategoryMiniDTO, IngredientCategoryForm, IngredientCategoryUpdateForm, Integer> {

    protected IngredientCategoryController(DefaultService <IngredientCategoryDTO, IngredientCategoryMiniDTO, IngredientCategoryForm, IngredientCategoryUpdateForm, Integer> service)  {
        super(service);
    }

}
