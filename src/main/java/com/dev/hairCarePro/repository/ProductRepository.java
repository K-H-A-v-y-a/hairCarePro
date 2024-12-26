package com.dev.hairCarePro.repository;

import com.dev.hairCarePro.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query to fetch products by their IDs
    @Query("SELECT p FROM Product p WHERE p.id IN :ids")
    List<Product> findAllById(List<Long> ids);
}

