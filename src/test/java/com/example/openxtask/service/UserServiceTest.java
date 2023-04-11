package com.example.openxtask.service;

import com.example.openxtask.model.user.Address;
import com.example.openxtask.model.user.Geolocation;
import com.example.openxtask.model.user.Name;
import com.example.openxtask.model.user.UserModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    public void testGetTwoUsersTheFurthestAwayFromEachOther() {

        UserModel user1 = new UserModel("Simon", new Address(new Geolocation(0, 0)));
        UserModel user2 = new UserModel("Mike", new Address(new Geolocation(1, 1)));
        UserModel user3 = new UserModel("Maja", new Address(new Geolocation(2, 2)));

        List<UserModel> users = List.of(user1, user2, user3);

        UserService userService = new UserService(users);

        UserModel[] expectedFurthestUsers = {user1, user3};
        UserModel[] actualFurthestUsers = userService.getTwoUsersTheFurthestAwayFromEachOther();

        assertArrayEquals(expectedFurthestUsers, actualFurthestUsers);

    }

    @Test
    public void getUserByIdTest(){

        UserModel user1 = new UserModel(new Address(new Geolocation(10, 10), "city", "street", new BigDecimal(123), "zipcode"), 1, "email", "user1", "password", new Name("firts", "last"), "phone", 0);
        UserModel user2 = new UserModel(new Address(new Geolocation(10, 10), "city", "street", new BigDecimal(123), "zipcode"), 2, "email", "user2", "password", new Name("firts", "last"), "phone", 0);
        UserModel user3 = new UserModel(new Address(new Geolocation(10, 10), "city", "street", new BigDecimal(123), "zipcode"), 3, "email", "user3", "password", new Name("firts", "last"), "phone", 0);

        List<UserModel> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        UserService userService = new UserService(users);

        assertEquals(user3, userService.getUserById(3));



    }


}