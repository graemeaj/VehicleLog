package com.example.graeme.vehiclelog;

public class VehicleItem {
    private String name;
    private String description1;
    private String description2;

    public VehicleItem(String name, String description1, String description2) {
        this.name = name;
        this.description1 = description1;
        this.description2 = description2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription1() {
        return (description1 != null) ? description1 : "";
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return (description2 != null) ? description2 : "";
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
