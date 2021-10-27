package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.ProductMapper;
import com.frterie.friterie.models.dto.ProductDTO;
import com.frterie.friterie.models.dto.ProductMiniDTO;
import com.frterie.friterie.models.entity.Ingredient;
import com.frterie.friterie.models.entity.Product;
import com.frterie.friterie.models.entity.ProductCategory;
import com.frterie.friterie.models.formAdd.ProductForm;
import com.frterie.friterie.models.formUpdate.ProductUpdateForm;
import com.frterie.friterie.repository.IngredientRepository;
import com.frterie.friterie.repository.ProductCategoryRepository;
import com.frterie.friterie.repository.ProductRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends DefaultServiceImplementation <ProductDTO, ProductMiniDTO, ProductForm, ProductUpdateForm, Product, Integer>{

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    protected ProductServiceImpl (ProductRepository repository, ProductMapper mapper){
        super(repository, mapper);
    }

    @Override
    public ProductDTO delete(Integer id) throws ElementNotFoundException {

        Product toDelete = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        System.out.println(toDelete.getName());

        Product ingredientManager = toDelete;
        toDelete.getIngredients()
                        .forEach(
                                ingredient -> {
                                    ingredient.deleteProduct(ingredientManager);
                                    ingredientRepository.save(ingredient);
                                }
                        );

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }

    @Override
    public ProductMiniDTO insert(ProductForm form) throws ElementNotFoundException {

        Product toInsert = mapper.toEntity(form);

        ProductCategory category = productCategoryRepository.findById(form.getCategoryID()).orElseThrow(null);

        List<Integer> idsIngredients = form.getIngredientListIDs();

        System.out.println(idsIngredients.toString());

        Set<Ingredient> ingredients = form.getIngredientListIDs()
                .stream()
                .map(
                        idIngredient -> ingredientRepository.findById(idIngredient)
                                .orElseThrow(null)
                )
                .collect(Collectors.toSet());
        toInsert.setIngredients(ingredients);
        toInsert.setCategory(category);

        toInsert = repository.save(toInsert);

        //Persist Ingredients
        Product toPeristIngredient = toInsert;
        toInsert.getIngredients()
                .forEach(
                        ingredient -> {
                            ingredient.addProduct(toPeristIngredient);
                            ingredientRepository.save(ingredient);
                        }
                );



        return mapper.toSmallDTO(toInsert);
    }

    @Override
    public ProductDTO update(Integer id, ProductUpdateForm form) throws ElementNotFoundException {

        Product toUpdate = repository.findById(id).orElseThrow(ElementNotFoundException::new);

        String name = form.getName();
        Double price = form.getPrice();
        List<Integer> ingredientListIDs = form.getIngredientListIDs();
        Integer categoryID = form.getCategoryID();

        if (name != null){
            toUpdate.setName(name);
        }

        if (price != null){
            toUpdate.setPrice(price);
        }

        if (ingredientListIDs.size() > 0){
            toUpdate.setIngredients(
                    ingredientListIDs
                            .stream()
                            .map(idIngredient ->  ingredientRepository.findById(idIngredient).orElseThrow(null))
                            .collect(Collectors.toSet())
            );
        }

        if (categoryID != null){
            toUpdate.setCategory(productCategoryRepository.findById(categoryID).orElseThrow(ElementNotFoundException::new));
        }

        Product finalToUpdate = toUpdate;
        toUpdate.getIngredients()
                .forEach(
                        ingredient -> {
                            ingredient.addProduct(finalToUpdate);
                            ingredientRepository.save(ingredient);
                        }
                );

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
