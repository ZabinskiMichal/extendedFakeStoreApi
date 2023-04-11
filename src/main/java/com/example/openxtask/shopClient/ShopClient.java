package com.example.openxtask.shopClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ShopClient {

    private static final String PRODUCTS_URL = "https://fakestoreapi.com/products";
    private static final String USERS_URL = "https://fakestoreapi.com/users";
    private static final String CARTS_URL = "https://fakestoreapi.com/carts";

    private RestTemplate restTemplate = new RestTemplate();


    public String getAllProducts(){
        return restTemplate.getForObject(PRODUCTS_URL, String.class);
    }

    public String getAllUsers(){
        return restTemplate.getForObject(USERS_URL, String.class);
    }

    public String getAllCarts(){
        return restTemplate.getForObject(CARTS_URL, String.class);
    }



}
