package com.example.user.salon;

import java.util.ArrayList;
import java.util.List;

public class Datum {
    private String _id;
    private String user_salon;
    private String name_salon;
    private String phone;
    private String address;
    private String city;
    private String description;
    private String opening_hours;
    private String location_lat;
    private String location_lon;
    private Relationships relationships;
    private ArrayList<String> image_salon = null;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_salon() {
        return user_salon;
    }

    public void setUser_salon(String user_salon) {
        this.user_salon = user_salon;
    }

    public String getName_salon() {
        return name_salon;
    }

    public void setName_salon(String name_salon) {
        this.name_salon = name_salon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(String location_lat) {
        this.location_lat = location_lat;
    }

    public String getLocation_lon() {
        return location_lon;
    }

    public void setLocation_lon(String location_lon) {
        this.location_lon = location_lon;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public List<String> getImage_salon() {
        return image_salon;
    }

    public void setImage_salon(ArrayList<String> image_salon) {
        this.image_salon = image_salon;
    }


}

