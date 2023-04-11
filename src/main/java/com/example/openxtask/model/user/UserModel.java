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


}
