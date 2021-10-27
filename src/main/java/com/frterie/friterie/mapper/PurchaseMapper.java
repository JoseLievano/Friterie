package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.PurchaseDTO;
import com.frterie.friterie.models.dto.PurchaseMiniDTO;
import com.frterie.friterie.models.entity.Purchase;
import com.frterie.friterie.models.formAdd.PurchaseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PurchaseMapper implements DefaultMapper <PurchaseDTO, PurchaseMiniDTO, PurchaseForm, Purchase> {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CostumerMapper costumerMapper;
    @Autowired
    private WorkerMapper workerMapper;

    public PurchaseDTO toDTO(Purchase entity){

        if (entity == null){
            return null;
        }

        return PurchaseDTO.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .date(entity.getDate())
                .state(entity.getState())
                .productList(
                        entity.getProductList()
                                .stream()
                                .map(productMapper::toSmallDTO)
                                .collect(Collectors.toList())
                )
                .costumer(costumerMapper.toSmallDTO(entity.getCostumer()))
                .worker(workerMapper.toSmallDTO(entity.getWorker()))
                .build();
    }

    @Override
    public PurchaseMiniDTO toSmallDTO(Purchase entity) {
        if (entity == null){
            return null;
        }

        return PurchaseMiniDTO.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .date(entity.getDate())
                .state(entity.getState())
                .productList(
                        entity.getProductList()
                                .stream()
                                .map(productMapper::toSmallDTO)
                                .collect(Collectors.toList())
                )
                .costumer(costumerMapper.toSmallDTO(entity.getCostumer()))
                .build();

    }

    public Purchase toEntity (PurchaseForm form){

        if (form == null)
            return null;

        return Purchase.builder()
                .date(form.getDate())
                .state(form.getState())
                .build();

    }

}
