package com.example.openxtask.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Geolocation {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("long")
    private double longitude;


//    public static double calculateDistance (Geolocation p1, Geolocation p2) {
//        double dx = p2.getLatitude() - p1.getLatitude();
//        double dy = p2.getLongitude() - p1.getLongitude();
//        return Math.sqrt(dx * dx + dy * dy);
//    }

    public static double calculateDistance (Geolocation p1, Geolocation p2) {
        double theta = p1.longitude - p2.longitude;
        double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                Math.sin(p1.latitude * (Math.PI/180)) * Math.sin(p2.latitude * (Math.PI/180)) +
                        Math.cos(p1.latitude * (Math.PI/180)) * Math.cos(p2.latitude * (Math.PI/180)) * Math.cos(theta * (Math.PI/180)));

        return distance*1.609;
    }
}
