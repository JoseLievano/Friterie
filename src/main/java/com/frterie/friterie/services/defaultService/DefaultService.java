package com.frterie.friterie.services.defaultService;

import com.frterie.friterie.exeptions.ElementNotFoundException;

import java.util.List;

public interface DefaultService <DTO, MINIDTO, FORM, UFORM, ID> {

    DTO getOne(ID id) throws ElementNotFoundException;

    List<DTO> getAll();

    MINIDTO insert(FORM form) throws ElementNotFoundException;

    DTO delete(ID id) throws ElementNotFoundException;

    DTO update(ID id, UFORM form) throws ElementNotFoundException;

}
