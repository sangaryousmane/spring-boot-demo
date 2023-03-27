package com.dailycodebuffer.springbootdemo.repository.backend;

import com.dailycodebuffer.springbootdemo.entities.backend.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository
        extends JpaRepository<ProductEntity, Integer> {
}
