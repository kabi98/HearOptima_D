package com.example.hearoptima_d_02.entity;

public class HearingAid {
    private int ha_id;
    private String ha_name;
    private String ha_type;
    private String ha_brand;
    private String ha_bluetooth;
    private String ha_content;
    private String ha_insurance;
    private int ha_min_price;
    private int ha_max_price;
    private String ha_etc;
    private int hri_id;
    private int hrii_id;

    public HearingAid() {
    }

    public HearingAid(int ha_id, String ha_name, String ha_type, String ha_brand, String ha_bluetooth, String ha_content, String ha_insurance, int ha_min_price, int ha_max_price, String ha_etc, int hri_id, int hrii_id) {
        this.ha_id = ha_id;
        this.ha_name = ha_name;
        this.ha_type = ha_type;
        this.ha_brand = ha_brand;
        this.ha_bluetooth = ha_bluetooth;
        this.ha_content = ha_content;
        this.ha_insurance = ha_insurance;
        this.ha_min_price = ha_min_price;
        this.ha_max_price = ha_max_price;
        this.ha_etc = ha_etc;
        this.hri_id = hri_id;
        this.hrii_id = hrii_id;
    }


    @Override
    public String toString() {
        return "HearingAid{" +
                "ha_id=" + ha_id +
                ", ha_name='" + ha_name + '\'' +
                ", ha_type='" + ha_type + '\'' +
                ", ha_brand='" + ha_brand + '\'' +
                ", ha_bluetooth='" + ha_bluetooth + '\'' +
                ", ha_content='" + ha_content + '\'' +
                ", ha_insurance='" + ha_insurance + '\'' +
                ", ha_min_price=" + ha_min_price +
                ", ha_max_price=" + ha_max_price +
                ", ha_etc='" + ha_etc + '\'' +
                ", hri_id=" + hri_id +
                ", hrii_id=" + hrii_id +
                '}';
    }

    public int getHa_id() {
        return ha_id;
    }

    public void setHa_id(int ha_id) {
        this.ha_id = ha_id;
    }

    public String getHa_name() {
        return ha_name;
    }

    public void setHa_name(String ha_name) {
        this.ha_name = ha_name;
    }

    public String getHa_type() {
        return ha_type;
    }

    public void setHa_type(String ha_type) {
        this.ha_type = ha_type;
    }

    public String getHa_brand() {
        return ha_brand;
    }

    public void setHa_brand(String ha_brand) {
        this.ha_brand = ha_brand;
    }

    public String getHa_bluetooth() {
        return ha_bluetooth;
    }

    public void setHa_bluetooth(String ha_bluetooth) {
        this.ha_bluetooth = ha_bluetooth;
    }

    public String getHa_content() {
        return ha_content;
    }

    public void setHa_content(String ha_content) {
        this.ha_content = ha_content;
    }

    public String getHa_insurance() {
        return ha_insurance;
    }

    public void setHa_insurance(String ha_insurance) {
        this.ha_insurance = ha_insurance;
    }

    public int getHa_min_price() {
        return ha_min_price;
    }

    public void setHa_min_price(int ha_min_price) {
        this.ha_min_price = ha_min_price;
    }

    public int getHa_max_price() {
        return ha_max_price;
    }

    public void setHa_max_price(int ha_max_price) {
        this.ha_max_price = ha_max_price;
    }

    public String getHa_etc() {
        return ha_etc;
    }

    public void setHa_etc(String ha_etc) {
        this.ha_etc = ha_etc;
    }

    public int getHri_id() {
        return hri_id;
    }

    public void setHri_id(int hri_id) {
        this.hri_id = hri_id;
    }

    public int getHrii_id() {
        return hrii_id;
    }

    public void setHrii_id(int hrii_id) {
        this.hrii_id = hrii_id;
    }
}

