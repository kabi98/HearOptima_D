package com.example.hearoptima_d_03.entity;

public class HrDataInfoUnit {
    int hrdiu_id;
    int hrdiu_right_ACT;
    int hrdiu_right_BCT;
    int hrdiu_right_WRS;
    int hrdiu_left_ACT;
    int hrdiu_left_BCT;
    int hrdiu_left_WRS;
    int hrdis_id;

    public HrDataInfoUnit(){
    }

    public HrDataInfoUnit(int hrdiu_id, int hrdis_id, int hrdiu_right_ACT, int hrdiu_right_BCT, int hrdiu_right_WRS, int hrdiu_left_ACT, int hrdiu_left_BCT, int hrdiu_left_WRS){
        this.hrdiu_id = hrdiu_id;
        this.hrdis_id = hrdis_id;
        this.hrdiu_right_ACT = hrdiu_right_ACT;
        this.hrdiu_right_BCT = hrdiu_right_BCT;
        this.hrdiu_right_WRS = hrdiu_right_WRS;
        this.hrdiu_left_ACT = hrdiu_left_ACT;
        this.hrdiu_left_BCT = hrdiu_left_BCT;
        this.hrdiu_left_WRS = hrdiu_left_WRS;
    }

    @Override
    public String toString(){
        return "HrDataInfoUnit{" +
                "hrdiu_id=" + hrdiu_id +
                ", hrdis_id=" + hrdis_id + '\'' +
                ", hrdiu_right_ACT='" + hrdiu_right_ACT + '\'' +
                ", hrdiu_right_BCT='" + hrdiu_right_BCT + '\'' +
                ", hrdiu_right_WRS='" + hrdiu_right_WRS + '\'' +
                ", hrdiu_left_ACT='" + hrdiu_left_ACT + '\'' +
                ", hrdiu_left_BCT='" + hrdiu_left_BCT + '\'' +
                ", hrdiu_left_WRS='" + hrdiu_left_WRS +
                '}';
    }

    public int getHrdiu_id() {return hrdiu_id;}
    public void setHrdiu_id(int hrdiu_id){this.hrdiu_id = hrdiu_id;}

    public int getHrdiu_right_ACT() {return hrdiu_right_ACT;}
    public void setHrdiu_right_ACT(int hrdiu_right_ACT){this.hrdiu_right_ACT = hrdiu_right_ACT;}

    public int getHrdiu_right_BCT() {return hrdiu_right_BCT;}
    public void setHrdiu_right_BCT(int hrdiu_right_BCT){this.hrdiu_right_BCT = hrdiu_right_BCT;}

    public int getHrdiu_right_WRS() {return hrdiu_right_WRS;}
    public void setHrdiu_right_WRS(int hrdiu_right_WRS){this.hrdiu_right_WRS = hrdiu_right_WRS;}

    public int getHrdiu_left_ACT() {return hrdiu_left_ACT;}
    public void setHrdiu_left_ACT(int hrdiu_left_ACT){this.hrdiu_left_ACT = hrdiu_left_ACT;}

    public int getHrdiu_left_BCT() {return hrdiu_left_BCT;}
    public void setHrdiu_left_BCT(int hrdiu_left_BCT){this.hrdiu_left_BCT = hrdiu_left_BCT;}

    public int getHrdiu_left_WRS() {return hrdiu_left_WRS;}
    public void setHrdiu_left_WRS(int hrdiu_left_WRS){this.hrdiu_left_WRS = hrdiu_left_WRS;}

    public int getHrdis_id() {return hrdis_id;}
    public void setHrdis_id(int hrdis_id){this.hrdis_id = hrdis_id;}
}
