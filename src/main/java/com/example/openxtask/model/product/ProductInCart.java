package com.example.openxtask.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductInCart {

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("quantity")
    private int quantity;


}
