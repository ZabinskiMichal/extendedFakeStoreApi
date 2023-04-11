package com.example.openxtask.controller;


import com.example.openxtask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {


    private final OrderService orderService;

    @Autowired
    public ProductController(OrderService orderService){
        this.orderService = orderService;
    }


//    returns product categories
    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return List.of(
                orderService.getCategoryToPrice().keySet().toArray(new String[0]));

    }


//    return all products categories and category value
    @GetMapping("/categories-with-price")
    public Map<String, Double> getProductsCategories() {
        return orderService.getCategoryToPrice();
    }




}
