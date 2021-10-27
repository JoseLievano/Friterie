package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.IngredientCategoryMapper;
import com.frterie.friterie.models.dto.IngredientCategoryDTO;
import com.frterie.friterie.models.dto.IngredientCategoryMiniDTO;
import com.frterie.friterie.models.entity.IngredientCategory;
import com.frterie.friterie.models.formAdd.IngredientCategoryForm;
import com.frterie.friterie.models.formUpdate.IngredientCategoryUpdateForm;
import com.frterie.friterie.repository.IngredientCategoryRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientCategoryServiceImpl extends DefaultServiceImplementation<IngredientCategoryDTO, IngredientCategoryMiniDTO, IngredientCategoryForm, IngredientCategoryUpdateForm, IngredientCategory, Integer> {

    protected IngredientCategoryServiceImpl(IngredientCategoryRepository repository, IngredientCategoryMapper mapper){super (repository, mapper);};

    @Override
    public IngredientCategoryDTO getOne(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(null);
    }

    @Override
    public List<IngredientCategoryDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientCategoryMiniDTO insert(IngredientCategoryForm form) {

        IngredientCategory toInsert = mapper.toEntity(form);

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);

    }

    @Override
    public IngredientCategoryDTO update(Integer id, IngredientCategoryUpdateForm form) throws ElementNotFoundException {

        IngredientCategory toUpdate = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        String newName = form.getName();

        if (newName != null){
            toUpdate.setName(newName);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }

}
