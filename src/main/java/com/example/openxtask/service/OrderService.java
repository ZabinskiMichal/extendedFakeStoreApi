package com.example.openxtask.service;

import com.example.openxtask.model.product.ProductModel;
import com.example.openxtask.shopClient.ShopClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@Getter
public class OrderService {

    private ShopClient shopClient;
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<ProductModel> productList;
    private Map<String, Double> categoryToPrice = new HashMap<>();


    @Autowired
    public OrderService(ShopClient shopClient) {
        this.shopClient = shopClient;
    }

    @PostConstruct
    private void init() throws JsonProcessingException {
        this.productList = objectMapper.readValue(shopClient.getAllProducts(), new TypeReference<List<ProductModel>>() {
        });
        assingPriceToCategory();
    }

    private void assingPriceToCategory(){
        for (ProductModel product: productList) {
            categoryToPrice.merge(product.getCategory(), product.getPrice(), Double::sum);
        }
    }


    public ProductModel getProductById(int id){
        for(ProductModel product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }



    public OrderService(List<ProductModel> productList){
        this.productList = productList;
    }













}
