package com.example.openxtask.model.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private BigDecimal number;
    private String zipcode;


    public Address(Geolocation geolocation){
        this.geolocation = geolocation;
    }
}
