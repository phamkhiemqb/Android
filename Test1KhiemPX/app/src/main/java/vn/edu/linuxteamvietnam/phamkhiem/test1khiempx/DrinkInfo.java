package vn.edu.linuxteamvietnam.phamkhiem.test1khiempx;

import java.io.Serializable;

public class DrinkInfo implements Serializable {
    String Name;
    double Price;

    public DrinkInfo(String name,double price) {
        Name = name;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }
}

