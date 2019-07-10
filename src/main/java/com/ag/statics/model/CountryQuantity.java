package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryQuantity implements Serializable {

    private static final long serialVersionUID = -6813064184940346595L;
    private Integer id;
    private String country;
    private Integer quantity;
    private double lat;
    private double lng;
    public CountryQuantity(){

    };
    public CountryQuantity(String country,Integer quantity){
        this.country = country;
        this.quantity = quantity;
    }
}
