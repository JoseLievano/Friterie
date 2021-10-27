package com.frterie.friterie.services.implementation;

import com.frterie.friterie.exeptions.ElementNotFoundException;
import com.frterie.friterie.mapper.ProductMapper;
import com.frterie.friterie.mapper.PurchaseMapper;
import com.frterie.friterie.models.dto.PurchaseDTO;
import com.frterie.friterie.models.dto.PurchaseMiniDTO;
import com.frterie.friterie.models.entity.Product;
import com.frterie.friterie.models.entity.Purchase;
import com.frterie.friterie.models.entity.User;
import com.frterie.friterie.models.formAdd.PurchaseForm;
import com.frterie.friterie.models.formUpdate.PurchaseUpdateForm;
import com.frterie.friterie.repository.IngredientRepository;
import com.frterie.friterie.repository.ProductRepository;
import com.frterie.friterie.repository.PurchaseRepository;
import com.frterie.friterie.repository.UserRepository;
import com.frterie.friterie.services.defaultService.DefaultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl extends DefaultServiceImplementation <PurchaseDTO, PurchaseMiniDTO, PurchaseForm, PurchaseUpdateForm, Purchase, Integer> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    protected PurchaseServiceImpl(PurchaseRepository repository, PurchaseMapper mapper){
        super(repository, mapper);
    }

    @Override
    public PurchaseMiniDTO insert(PurchaseForm form) throws ElementNotFoundException {

        Purchase toInsert = mapper.toEntity(form);

        Double price = form.getProductsID()
                .stream()
                .map(id -> productRepository.findById(id).orElseThrow(null))
                .mapToDouble(product -> product.getPrice())
                .sum();

        List<Product> productList = form.getProductsID()
                .stream()
                .map(id -> productRepository.findById(id).orElseThrow(null))
                .collect(Collectors.toList());

        User costumer = userRepository.findById(form.getCostumerID()).get();

        toInsert.setState(form.getState());
        toInsert.setPrice(price);
        toInsert.setProductList(productList);
        toInsert.setCostumer(costumer);

        repository.save(toInsert);

        //Reduce the stock of ingredients inside the products
        toInsert.getProductList()
                        .forEach(
                                product -> {
                                    product.getIngredients()
                                            .forEach(
                                                    ingredient -> {
                                                        ingredient.reduceStock(1);
                                                        ingredientRepository.save(ingredient);
                                                    }
                                            );
                                }
                        );


        return mapper.toSmallDTO(toInsert);
    }

    @Override
    public PurchaseDTO update(Integer id, PurchaseUpdateForm form) throws ElementNotFoundException {

        Purchase toUpdate = repository.findById(id).orElseThrow();

        Integer workerID = form.getWorkerID();
        String state = form.getState();

        if (workerID != null){
            toUpdate.setWorker(userRepository.findById(workerID).orElseThrow(null));
        }

        if (state != null){
            toUpdate.setState(state);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
