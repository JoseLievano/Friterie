package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.CostumerDTO;
import com.frterie.friterie.models.dto.CostumerMiniDTO;
import com.frterie.friterie.models.entity.User;
import com.frterie.friterie.models.formAdd.CostumerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CostumerMapper implements DefaultMapper <CostumerDTO, CostumerMiniDTO, CostumerForm, User>{

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public CostumerDTO toDTO(User entity) {

        if (entity == null)
            return null;

        return CostumerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .role(entity.getRole())
                .orders(entity.getOrders()
                        .stream()
                        .map(purchaseMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @Override
    public CostumerMiniDTO toSmallDTO(User entity) {

        if (entity == null)
            return null;

        return CostumerMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .role(entity.getRole())
                .build();

    }

    @Override
    public User toEntity(CostumerForm form) {

        if (form == null)
            return null;

        return User.builder()
                .name(form.getName())
                .username(form.getUsername())
                .password(form.getPassword())
                .build();

    }
}
