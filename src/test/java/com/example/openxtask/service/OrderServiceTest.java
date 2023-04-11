package com.example.openxtask.service;

import com.example.openxtask.model.product.ProductModel;
import com.example.openxtask.model.product.Rating;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    @Test
    public void getProductByIdTest(){

        ProductModel product1 = new ProductModel(1, "Ball1", 30.0, "desc", "cat", "img", new Rating(3, 3));
        ProductModel product2 = new ProductModel(2, "Ball2", 30.0, "desc", "cat", "img", new Rating(3, 3));
        ProductModel product3 = new ProductModel(3, "Ball3", 30.0, "desc", "cat", "img", new Rating(3, 3));

        List<ProductModel> products = new ArrayList<>();

        products.add(product1);
        products.add(product2);
        products.add(product3);

        OrderService orderService = new OrderService(products);

        assertEquals(product2, orderService.getProductById(2));

    }

}