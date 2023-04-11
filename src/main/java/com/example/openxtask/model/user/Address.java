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

    //    {"address":{"geolocation":{"lat":"-37.3159","long":"81.1496"},"city":"kilcoole","street":"new road","number":7682,"zipcode":"12926-3874"},


    public Address(Geolocation geolocation){
        this.geolocation = geolocation;
    }
}
