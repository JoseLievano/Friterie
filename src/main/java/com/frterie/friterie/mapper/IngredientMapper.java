package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.IngredientDTO;
import com.frterie.friterie.models.dto.IngredientMiniDTO;
import com.frterie.friterie.models.entity.Ingredient;
import com.frterie.friterie.models.formAdd.IngredientForm;
import com.frterie.friterie.services.implementation.IngredientCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper implements DefaultMapper<IngredientDTO, IngredientMiniDTO, IngredientForm, Ingredient>{

    @Autowired
    private IngredientCategoryMapper IngredientCategoryMapper;

    @Override
    public IngredientDTO toDTO(Ingredient entity) {
        if (entity == null)
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stock(entity.getStock())
                .cost(entity.getCost())
                .category(IngredientCategoryMapper.toSmallDTO(entity.getCategory()))
                .build();
    }

    @Override
    public Ingredient toEntity(IngredientForm form) {
        if (form == null)
            return null;

        return Ingredient.builder()
                .name(form.getName())
                .stock(form.getStock())
                .cost(form.getCost())
                .build();
    }

    public IngredientMiniDTO toSmallDTO (Ingredient entity){

        if (entity == null)
            return null;

        return IngredientMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .stock(entity.getStock())
                .cost(entity.getCost())
                .build();
    }


}
