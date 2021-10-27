package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.*;
import com.frterie.friterie.models.entity.IngredientCategory;
import com.frterie.friterie.models.formAdd.IngredientCategoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class IngredientCategoryMapper implements DefaultMapper<IngredientCategoryDTO, IngredientCategoryMiniDTO, IngredientCategoryForm, IngredientCategory> {

    @Autowired
    private IngredientMapper ingredientMapper;

    @Override
    public IngredientCategoryDTO toDTO (IngredientCategory entity){

        if (entity == null)
            return null;

        return IngredientCategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ingredientDTOS(
                        entity.getIngredientsList()
                        .stream()
                        .map(ingredientMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @Override
    public IngredientCategoryMiniDTO toSmallDTO(IngredientCategory entity){

        if (entity == null)
            return null;

        return IngredientCategoryMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }

    @Override
    public IngredientCategory toEntity (IngredientCategoryForm form){

        if (form == null)
            return null;

        return IngredientCategory.builder()
                .name(form.getName())
                .build();

    }


}
