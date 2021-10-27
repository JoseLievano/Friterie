package com.frterie.friterie.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private Double price;

    @Column (nullable = false)
    private String state;

    @Column (nullable = false)
    private Date date;

    @ManyToMany
    @Column(nullable = false)
    private List<Product> productList;

    @ManyToOne
    private User costumer;

    @ManyToOne
    private User worker;
}
