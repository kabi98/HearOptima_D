package com.example.hearoptima_d_02.entity;

public class AidsView {
    String file_name;
    String brand;
    String product;
    int maxPrice;

    int ha_id;

    public AidsView() {
    }

    public AidsView(String file_name, String brand, String product, int maxPrice) {
        this.file_name = file_name;
        this.brand = brand;
        this.product = product;
        this.maxPrice = maxPrice;
        this.ha_id = ha_id;
    }

    @Override
    public String toString() {
        return "AidsView{" +
                "file_name='" + file_name + '\'' +
                ", brand='" + brand + '\'' +
                ", product='" + product + '\'' +
                ", maxPrice=" + maxPrice +
                ", ha_id=" + ha_id +
                '}';
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getHa_id() {return ha_id;}
    public void setHa_id(int ha_id) {this.ha_id=ha_id;}
}
