package com.frterie.friterie.repository;

import com.frterie.friterie.models.entity.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Integer> {

    @Query("SELECT u FROM IngredientCategory u WHERE u.name = ?1")
    boolean findByCategoryName(String name);

}
