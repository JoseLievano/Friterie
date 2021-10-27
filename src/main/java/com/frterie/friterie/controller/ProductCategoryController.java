package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.ProductCategoryDTO;
import com.frterie.friterie.models.dto.ProductCategoryMiniDTO;
import com.frterie.friterie.models.formAdd.ProductCategoryForm;
import com.frterie.friterie.models.formUpdate.ProductCategoryUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController extends AbstractCrudController <ProductCategoryDTO, ProductCategoryMiniDTO, ProductCategoryForm, ProductCategoryUpdateForm, Integer>  {

    protected ProductCategoryController(DefaultService <ProductCategoryDTO, ProductCategoryMiniDTO, ProductCategoryForm, ProductCategoryUpdateForm, Integer> service){
        super(service);
    }

}
