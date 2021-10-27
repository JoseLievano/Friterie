package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.ProductCategoryMapper;
import com.frterie.friterie.models.dto.ProductCategoryDTO;
import com.frterie.friterie.models.dto.ProductCategoryMiniDTO;
import com.frterie.friterie.models.entity.ProductCategory;
import com.frterie.friterie.models.formAdd.ProductCategoryForm;
import com.frterie.friterie.models.formUpdate.ProductCategoryUpdateForm;
import com.frterie.friterie.repository.ProductCategoryRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl extends DefaultServiceImplementation <ProductCategoryDTO, ProductCategoryMiniDTO, ProductCategoryForm, ProductCategoryUpdateForm, ProductCategory, Integer> {

    protected ProductCategoryServiceImpl(ProductCategoryRepository repository, ProductCategoryMapper mapper){
        super(repository, mapper);
    }

    @Override
    public ProductCategoryDTO update(Integer id, ProductCategoryUpdateForm form) throws ElementNotFoundException {

        ProductCategory toUpdate = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        String name = form.getName();

        if (name != null){
            toUpdate.setName(name);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
