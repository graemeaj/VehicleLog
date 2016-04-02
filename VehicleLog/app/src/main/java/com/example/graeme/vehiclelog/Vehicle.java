package com.example.graeme.vehiclelog;

import java.util.Date;
import java.util.HashMap;

public class Vehicle {
    private String name;
    private int year;
    private String engineSize;
    private Date expiration;
    private String vin;
    private HashMap<String, VehicleItem> items;

    public Vehicle(String name, int year, String engineSize, Date expiration, String vin) {
        this.name = name;
        this.year = year;
        this.engineSize = engineSize;
        this.expiration = expiration;
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
