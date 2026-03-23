package com.example.marvelspring.repository;

import com.example.marvelspring.entity.MyTestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTestProductRepository extends JpaRepository<MyTestProduct, Long> {
}
