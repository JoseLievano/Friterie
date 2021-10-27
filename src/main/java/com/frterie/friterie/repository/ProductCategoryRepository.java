package com.frterie.friterie.repository;

import com.frterie.friterie.models.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository <ProductCategory, Integer> {
}
