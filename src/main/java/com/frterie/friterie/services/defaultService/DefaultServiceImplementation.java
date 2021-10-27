package com.frterie.friterie.services.defaultService;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.DefaultMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class DefaultServiceImplementation <DTO, MINIDTO, FORM, UFORM,ENTITY, ID> implements DefaultService<DTO,MINIDTO, FORM, UFORM, ID> {

    protected final JpaRepository<ENTITY, ID> repository;
    protected final DefaultMapper<DTO, MINIDTO, FORM, ENTITY> mapper;

    public DefaultServiceImplementation(JpaRepository<ENTITY, ID> repository, DefaultMapper<DTO, MINIDTO, FORM, ENTITY> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DTO getOne(ID id) throws ElementNotFoundException {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<DTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MINIDTO insert(FORM form) throws ElementNotFoundException {

        return mapper.toSmallDTO( repository.save(mapper.toEntity(form)) );

    }

    @Override
    public DTO delete(ID id) throws ElementNotFoundException {

        ENTITY tentity = repository.findById(id)
                .orElseThrow(null);
        repository.delete(tentity);
        return mapper.toDTO(tentity);
    }

    @Override
    public DTO update(ID id, UFORM form) throws ElementNotFoundException {

        return null;

    }
}
