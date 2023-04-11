package com.example.openxtask.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.awt.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class UserModel {

    @JsonProperty("address")
    private Address address;

    @JsonProperty("id")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("__v")
    private int strangeParam;


    public UserModel(String name, Address address){
        this.address = address;
    }



//    {"address":{"geolocation":{"lat":"-37.3159","long":"81.1496"},"city":"kilcoole","street":"new road","number":7682,"zipcode":"12926-3874"},
//    "id":1,
//    "email":"john@gmail.com",
//    "username":"johnd",
//    "password":"m38rmF$",
//    "name":{"firstname":"john","lastname":"doe"},
//    "phone":"1-570-236-7033","__v":0}






}
