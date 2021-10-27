package com.frterie.friterie.controller;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.models.dto.ProductDTO;
import com.frterie.friterie.models.dto.ProductMiniDTO;
import com.frterie.friterie.models.formAdd.ProductForm;
import com.frterie.friterie.models.formUpdate.ProductUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController <ProductDTO, ProductMiniDTO, ProductForm, ProductUpdateForm, Integer>{

    protected ProductController(DefaultService <ProductDTO, ProductMiniDTO, ProductForm, ProductUpdateForm, Integer> service){
        super(service);
    }

}
