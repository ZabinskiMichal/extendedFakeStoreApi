package com.example.openxtask.service;


import com.example.openxtask.model.product.CartModel;
import com.example.openxtask.model.product.ProductInCart;
import com.example.openxtask.model.product.ProductModel;
import com.example.openxtask.model.user.UserModel;
import com.example.openxtask.shopClient.ShopClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@Getter
public class CartService {

    private ShopClient shopClient;
    private OrderService orderService;
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<CartModel> carts;

    @Autowired
    public CartService(ShopClient shopClient, OrderService orderService, UserService userService) {
        this.shopClient = shopClient;
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        this.carts = objectMapper.readValue(shopClient.getAllCarts(), new TypeReference<List<CartModel>>() {
        });

    }

    public String getHighestValueCart() {
        double cartValue = 0;
        double newCartValue = 0;
        int cartsUserId = -1;

        for (CartModel currentCart : carts) {
             newCartValue = getCartValue(currentCart);
            if(newCartValue > cartValue){
                cartValue = newCartValue;
                cartsUserId = currentCart.getUserId();
            }

        }

        UserModel cartsOwner = userService.getUserById(cartsUserId);
        return "cart value: " + cartValue + ", cart owner: " + cartsOwner.getUsername();

    }

        public double getCartValue(CartModel cart) {
        int cartValue = 0;

        List<ProductInCart> productsInCarts = cart.getProducts();

        for (ProductInCart currentProductInCart: productsInCarts) {
            ProductModel productModel = orderService.getProductById(currentProductInCart.getProductId());
            int productQuantity = currentProductInCart.getQuantity();
            double currentPrice = productQuantity * productModel.getPrice();
            cartValue += currentPrice;

        }

        return cartValue;

    }


}
