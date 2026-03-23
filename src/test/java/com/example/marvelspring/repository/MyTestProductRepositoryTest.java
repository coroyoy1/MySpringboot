package com.example.marvelspring.repository;

import com.example.marvelspring.entity.MyTestProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MyTestProductRepositoryTest {

    @Autowired
    private MyTestProductRepository repository;

    @Test
    void saveProduct() {
        MyTestProduct MyTestProduct = new MyTestProduct(null, "Phone", 20000);

        MyTestProduct saved = repository.save(MyTestProduct);

        assertNotNull(saved.getId());
        assertEquals("Phone", saved.getName());
    }
}
