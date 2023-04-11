package com.example.openxtask.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartModel {

    @JsonProperty("id")
    private int id;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("products")
    private List<ProductInCart> products;

    @JsonProperty("__v")
    private String param;



}
