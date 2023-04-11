package com.example.openxtask.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Name {


    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

}
