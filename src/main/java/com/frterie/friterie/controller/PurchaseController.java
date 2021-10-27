package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.PurchaseDTO;
import com.frterie.friterie.models.dto.PurchaseMiniDTO;
import com.frterie.friterie.models.formAdd.PurchaseForm;
import com.frterie.friterie.models.formUpdate.PurchaseUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController extends AbstractCrudController <PurchaseDTO, PurchaseMiniDTO, PurchaseForm, PurchaseUpdateForm, Integer>{

    protected PurchaseController(DefaultService <PurchaseDTO, PurchaseMiniDTO, PurchaseForm, PurchaseUpdateForm, Integer> service){
        super(service);
    }

}
