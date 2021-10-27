package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.ProductCategoryDTO;
import com.frterie.friterie.models.dto.ProductDTO;
import com.frterie.friterie.models.dto.ProductMiniDTO;
import com.frterie.friterie.models.entity.Product;
import com.frterie.friterie.models.formAdd.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductMapper implements DefaultMapper<ProductDTO, ProductMiniDTO, ProductForm, Product>{

    @Autowired
    private IngredientMapper ingredientMapper;

    @Autowired
    private ProductCategoryMapper productCatMapper;

    @Override
    public ProductDTO toDTO(Product entity) {
        if(entity == null)
            return null;

        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .ingredientMiniDTOs(
                        entity.getIngredients()
                                .stream()
                                .map(ingredientMapper::toSmallDTO)
                                .collect(Collectors.toList())
                )
                .category(productCatMapper.toSmallDTO(entity.getCategory()))
                .build();
    }

    @Override
    public ProductMiniDTO toSmallDTO(Product entity) {

        if(entity == null)
            return null;

        return ProductMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();

    }

    @Override
    public Product toEntity(ProductForm form) {

        if (form == null)
            return null;

        return Product.builder()
                .name(form.getName())
                .price(form.getPrice())
                .build();
    }


}
