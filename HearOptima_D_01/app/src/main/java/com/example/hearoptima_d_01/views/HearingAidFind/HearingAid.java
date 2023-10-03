package com.example.hearoptima_d_01.views.HearingAidFind;

public class HearingAid {
    private int imageResourceId;
    private String name;

    public HearingAid(int imageResourceId, String name) {
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }
}
