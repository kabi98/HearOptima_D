package com.example.hearoptima_d_02.entity;

import java.util.ArrayList;

public class FilterDTO {
    int maxPrice;
    int minPrice;
    ArrayList<Filter> brands = new ArrayList<>();
    ArrayList<Filter> shapes = new ArrayList<>();

    @Override
    public String toString() {
        return "FilterDTO{" +
                "maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", brands=" + brands +
                ", shapes=" + shapes +
                '}';
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public ArrayList<Filter> getBrands() {
        return brands;
    }

    public void setBrands(ArrayList<Filter> brands) {
        this.brands = brands;
    }

    public ArrayList<Filter> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Filter> shapes) {
        this.shapes = shapes;
    }

    public FilterDTO() {
    }

    public FilterDTO(int maxPrice, int minPrice, ArrayList<Filter> brands, ArrayList<Filter> shapes) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.brands = brands;
        this.shapes = shapes;
    }
}
