package com.frterie.friterie.mapper;

import com.frterie.friterie.models.dto.WorkerDTO;
import com.frterie.friterie.models.dto.WorkerMiniDTO;
import com.frterie.friterie.models.entity.User;
import com.frterie.friterie.models.formAdd.WorkerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class WorkerMapper implements DefaultMapper <WorkerDTO, WorkerMiniDTO, WorkerForm, User>{

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public WorkerDTO toDTO(User entity) {

        if (entity == null)
            return null;

        return WorkerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .role(entity.getRole())
                .delivery(entity.getDelivery()
                        .stream()
                        .map(purchaseMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();



    }

    @Override
    public WorkerMiniDTO toSmallDTO(User entity) {

        if (entity == null)
            return null;

        return WorkerMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .role(entity.getRole())
                .build();

    }

    @Override
    public User toEntity(WorkerForm form) {

        if (form == null)
            return null;

        return User.builder()
                .name(form.getName())
                .username(form.getUsername())
                .password(form.getPassword())
                .build();
    }
}
