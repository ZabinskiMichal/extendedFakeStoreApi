package com.example.openxtask.controller;


import com.example.openxtask.model.user.UserModel;
import com.example.openxtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/furthest")
    public UserModel[] getFurthestUsers(){
        return userService.getTwoUsersTheFurthestAwayFromEachOther();
    }
}
