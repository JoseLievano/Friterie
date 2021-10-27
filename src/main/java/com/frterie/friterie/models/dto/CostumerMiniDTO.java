package com.frterie.friterie.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CostumerMiniDTO {

    private Integer id;

    private String name;

    private String username;

    private String role;

}
