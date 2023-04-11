package com.example.openxtask.service;

import com.example.openxtask.model.user.Geolocation;
import com.example.openxtask.model.user.UserModel;
import com.example.openxtask.shopClient.ShopClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private ShopClient shopClient;
    private List<UserModel> users;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UserService(ShopClient shopClient){
        this.shopClient = shopClient;
    }



    @PostConstruct
    private void init() throws JsonProcessingException {
        this.users = objectMapper.readValue(shopClient.getAllUsers(), new TypeReference<List<UserModel>>() {
        });
    }


    public UserModel[] getTwoUsersTheFurthestAwayFromEachOther(){
        double maxDistance = 0;
        UserModel[] furthestUsers = new UserModel[2];

        for(int i = 0; i < users.size(); i++){
            for (int j = i + 1; j < users.size(); j++){
                double distance = Geolocation.calculateDistance(users.get(i).getAddress().getGeolocation(), users.get(j).getAddress().getGeolocation());
                if(distance > maxDistance){
                    maxDistance = distance;
                    furthestUsers[0] = users.get(i);
                    furthestUsers[1] = users.get(j);
                }
            }
        }
        return furthestUsers;

    }

    public UserService(List<UserModel> users){
        this.users = users;

    }


    public UserModel getUserById(int id){

        for(UserModel user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }


}
