package com.frterie.friterie.controller;

import com.frterie.friterie.models.dto.WorkerDTO;
import com.frterie.friterie.models.dto.WorkerMiniDTO;
import com.frterie.friterie.models.formAdd.WorkerForm;
import com.frterie.friterie.models.formUpdate.WorkerUpdateForm;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class WorkerController extends AbstractCrudController <WorkerDTO, WorkerMiniDTO, WorkerForm, WorkerUpdateForm, Integer>{

    protected WorkerController (DefaultService <WorkerDTO, WorkerMiniDTO, WorkerForm, WorkerUpdateForm, Integer> service){
        super(service);
    }
}
