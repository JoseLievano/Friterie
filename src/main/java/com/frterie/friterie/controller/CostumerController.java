package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.CostumerDTO;
import com.frterie.friterie.models.dto.CostumerMiniDTO;
import com.frterie.friterie.models.formAdd.CostumerForm;
import com.frterie.friterie.models.formUpdate.CostumerUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costumer")
public class CostumerController extends AbstractCrudController <CostumerDTO, CostumerMiniDTO, CostumerForm, CostumerUpdateForm, Integer> {

    protected CostumerController(DefaultService <CostumerDTO, CostumerMiniDTO, CostumerForm, CostumerUpdateForm, Integer> service){
        super(service);
    }

}
