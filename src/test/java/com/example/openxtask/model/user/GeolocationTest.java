package com.example.openxtask.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeolocationTest {

    @Test
    public void testCalculatingDistance(){


        Geolocation p1 = new Geolocation(52.13, 21.00); // Warsaw
        Geolocation p2 = new Geolocation(50.18, 18.41); // Gliwice

        double expectedDistance = 282;

        double actualDistanceInKM = Geolocation.calculateDistance(p1, p2);

        double allowableErrorInKMs = 0.2;

        assertEquals(expectedDistance, actualDistanceInKM, allowableErrorInKMs);
    }

}