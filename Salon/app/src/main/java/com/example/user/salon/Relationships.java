package com.example.user.salon;

import android.app.Service;

import java.util.ArrayList;
import java.util.List;

public class Relationships {


    private ArrayList<com.example.user.salon.Service> services = null;

    public ArrayList<com.example.user.salon.Service> getServices() {
        return services;
    }

    public void setServices(ArrayList<com.example.user.salon.Service> services) {
        this.services = services;
    }

}