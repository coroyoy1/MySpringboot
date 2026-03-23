package com.example.marvelspring.controller;

import com.example.marvelspring.entity.MyTestProduct;
import com.example.marvelspring.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MyTestProductController.class)
class MyProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void createNewProduct() throws Exception {
        MyTestProduct MyTestProduct = new MyTestProduct(1L, "Iphone 20", 50000);

        Mockito.when(productService.createProduct(Mockito.any()))
                .thenReturn(MyTestProduct);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Laptop\",\"price\":50000}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Iphone 20"))
                .andExpect(jsonPath("$.price").value(50000));
    }
}
