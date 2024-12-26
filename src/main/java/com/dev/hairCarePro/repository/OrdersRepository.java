package com.dev.hairCarePro.repository;

import com.dev.hairCarePro.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // You can add custom queries here if needed, but JpaRepository provides basic CRUD operations
}
