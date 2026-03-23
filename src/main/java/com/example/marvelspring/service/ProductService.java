package com.example.marvelspring.service;

import com.example.marvelspring.entity.MyTestProduct;
import com.example.marvelspring.repository.MyTestProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final MyTestProductRepository repository;

    public ProductService(MyTestProductRepository repository) {
        this.repository = repository;
    }

    public MyTestProduct createProduct(MyTestProduct MyTestProduct) {
        return repository.save(MyTestProduct);
    }
}
