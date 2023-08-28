package com.example.diansspring.model;


import com.example.diansspring.model.enums.AmenityType;
import lombok.Data;

import java.util.Locale;


@Data
public class Amenity {

    private Long id;
    private String name;
    private String address;
    private AmenityType amenityType;
    private String municipality;
    private int rating; //from 1 to 5
    private float longitude;
    private float latitude;


    public Amenity(Long id,
                   String name,
                   String address,
                   String amenityType,
                   float longitude,
                   float latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.amenityType = whatAmenityType(amenityType.toUpperCase()); //method to choose which type is
        this.longitude = longitude;
        this.latitude = latitude;
        this.rating = 3; //default
    }

    public static Amenity create(String inputLine) {
        String [] parts = inputLine.split(",");

        Long id = Long.parseLong(parts[0]);
        String name = parts[1];
        String address = parts[2];
        String amenityType = parts[3];
        float longitude = Float.parseFloat(parts[4]);
        float latitude = Float.parseFloat(parts[5]);

        return new Amenity(id, name, address, amenityType, longitude, latitude);

    }

    private AmenityType whatAmenityType(String amenityType) {
        if(amenityType.equals(String.valueOf(AmenityType.BAR))) return AmenityType.BAR;
        else if(amenityType.equals(String.valueOf(AmenityType.PUB))) return AmenityType.PUB;
        else if(amenityType.equals(String.valueOf(AmenityType.FAST_FOOD))) return AmenityType.FAST_FOOD;
        else if(amenityType.equals(String.valueOf(AmenityType.CAFE))) return AmenityType.CAFE;
        else return AmenityType.RESTAURANT;
    }
}
