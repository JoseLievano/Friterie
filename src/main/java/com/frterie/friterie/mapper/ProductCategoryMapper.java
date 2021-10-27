package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.ProductCategoryDTO;
import com.frterie.friterie.models.dto.ProductCategoryMiniDTO;
import com.frterie.friterie.models.entity.ProductCategory;
import com.frterie.friterie.models.formAdd.ProductCategoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductCategoryMapper implements DefaultMapper <ProductCategoryDTO, ProductCategoryMiniDTO, ProductCategoryForm, ProductCategory>{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductCategoryDTO toDTO(ProductCategory entity) {
        if (entity == null)
            return null;

        return ProductCategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productDTOS(
                        entity.getProducts()
                                .stream()
                                .map(productMapper::toSmallDTO)
                                .collect(Collectors.toList())
                )
                .build();


    }

    @Override
    public ProductCategoryMiniDTO toSmallDTO(ProductCategory entity) {

        if (entity == null)
            return null;

        return ProductCategoryMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }

    @Override
    public ProductCategory toEntity(ProductCategoryForm form) {

        if (form == null)
            return null;

        return ProductCategory.builder()
                .name(form.getName())
                .build();

    }

}
