package com.example.marvelspring.controller;

import com.example.marvelspring.entity.MyTestProduct;
import com.example.marvelspring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class MyTestProductController {

    private final ProductService service;

    public MyTestProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MyTestProduct> createProduct(@RequestBody MyTestProduct MyTestProduct) {
        MyTestProduct saved = service.createProduct(MyTestProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
