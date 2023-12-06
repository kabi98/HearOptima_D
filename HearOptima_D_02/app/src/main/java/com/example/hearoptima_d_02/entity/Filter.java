package com.example.hearoptima_d_02.entity;

public class Filter {
    String item;
    Boolean isId;
    String value;

    @Override
    public String toString() {
        return "Filter{" +
                "item='" + item + '\'' +
                ", isId=" + isId +
                ", value='" + value + '\'' +
                '}';
    }

    public Filter(String item, Boolean isId, String value) {
        this.item = item;
        this.isId = isId;
        this.value = value;
    }

    public Filter() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getId() {
        return isId;
    }

    public void setId(Boolean id) {
        isId = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
