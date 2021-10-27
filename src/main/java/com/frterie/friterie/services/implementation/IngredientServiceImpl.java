package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.IngredientMapper;
import com.frterie.friterie.models.dto.IngredientDTO;
import com.frterie.friterie.models.dto.IngredientMiniDTO;
import com.frterie.friterie.models.entity.Ingredient;
import com.frterie.friterie.models.entity.IngredientCategory;
import com.frterie.friterie.models.formAdd.IngredientForm;
import com.frterie.friterie.models.formUpdate.IngredientUpdateForm;
import com.frterie.friterie.repository.IngredientCategoryRepository;
import com.frterie.friterie.repository.IngredientRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl extends DefaultServiceImplementation<IngredientDTO, IngredientMiniDTO, IngredientForm, IngredientUpdateForm, Ingredient, Integer>  {

    @Autowired
    private IngredientCategoryRepository catRepository;

    protected IngredientServiceImpl(IngredientRepository repository, IngredientMapper mapper){
        super(repository, mapper);
    }


    @Override
    public IngredientMiniDTO insert(IngredientForm form) throws ElementNotFoundException {

        Ingredient toInsert = mapper.toEntity(form);

        IngredientCategory category = catRepository.findById(form.getCategoryID()).orElseThrow(ElementNotFoundException::new);

        //Get the value of the optional variable with the correct type
        toInsert.setCategory( category);

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);
    }

    @Override
    public IngredientDTO update(Integer id, IngredientUpdateForm form) throws ElementNotFoundException {

        Ingredient toUpdate = repository.findById(id)
                .orElseThrow(ElementNotFoundException::new);

        //Get all the variables inside the update form
        String newName = form.getName();
        Double newCost = form.getCost();
        Integer newStock = form.getStock();
        Integer newCategoryInt = form.getCategoryID();

        if (newName != null){
            toUpdate.setName(newName);
        }

        if (newCost != null){
            toUpdate.setCost(newCost);
        }

        if (newStock != null){
            toUpdate.setStock(newStock);
        }

        if (newCategoryInt != null){
            IngredientCategory category = catRepository.findById(newCategoryInt).orElseThrow(ElementNotFoundException::new);
            toUpdate.setCategory(category);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
