package com.frterie.friterie.controller;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.services.defaultService.DefaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudController <DTO, MINIDTO, FORM, UFORM, ID> {

    private final DefaultService <DTO, MINIDTO, FORM, UFORM, ID> service;

    protected AbstractCrudController(DefaultService<DTO, MINIDTO, FORM, UFORM, ID> service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementNotFoundException {
        return ResponseEntity.ok( service.getOne(id) );
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getOne(){
        return ResponseEntity.ok( service.getAll() );
    }

    @PostMapping
    public ResponseEntity<MINIDTO> insert(@Valid @RequestBody FORM form) throws ElementNotFoundException {
        return ResponseEntity.ok( service.insert(form) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementNotFoundException {
        return ResponseEntity.ok( service.delete(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @Valid @RequestBody UFORM tform) throws ElementNotFoundException {
        return ResponseEntity.ok( service.update(id, tform) );
    }

}
