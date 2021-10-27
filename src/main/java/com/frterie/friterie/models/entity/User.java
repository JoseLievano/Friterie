package com.frterie.friterie.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany (mappedBy = "costumer", fetch = FetchType.EAGER)
    private List<Purchase> orders;

    @OneToMany (mappedBy = "worker", fetch = FetchType.EAGER)
    private List<Purchase> delivery;

}
