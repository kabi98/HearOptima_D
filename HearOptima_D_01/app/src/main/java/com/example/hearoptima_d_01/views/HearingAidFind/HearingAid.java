package com.example.hearoptima_d_01.views.HearingAidFind;

public class HearingAid {
    private int imageResourceId;
    private String name;
    private String brand;
    private String price;

    public HearingAid(int imageResourceId, String name, String brand, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getPrice() {
        return price;
    }
}
