package com.frterie.friterie.models.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkerDTO {

    private Integer id;

    private String name;

    private String username;

    private String role;

    private List<PurchaseMiniDTO> delivery;

}
