package com.example.hearoptima_d_03.entity;

public class HrDataInfoSet {
    int hrdis_id;
    String hrdis_date;
    String hrdis_result;
    String hrdis_type;
    int acc_id;

    public HrDataInfoSet(){
    }

    public HrDataInfoSet(int hrdis_id, String hrdis_date, String hrdis_result, String hrdis_type, int acc_id){
        this.hrdis_id = hrdis_id;
        this.hrdis_date = hrdis_date;
        this.hrdis_result = hrdis_result;
        this.hrdis_type = hrdis_type;
        this.acc_id =acc_id;
    }

    @Override
    public String toString(){
        return "HrDataInfoSet{" +
                "hrdis_id=" + hrdis_id + '\'' +
                ", hrdis_date='" + hrdis_date + '\'' +
                ", hrdis_result='" + hrdis_result + '\'' +
                ", hrdis_type='" + hrdis_result + '\'' +
                ", acc_id=" + acc_id +
                '}';
    }
    public int getHrdis_id() {return hrdis_id;}
    public void setHrdis_id(int hrdis_id){this.hrdis_id = hrdis_id;}

    public String getHrdis_date() {return hrdis_date;}
    public void setHrdis_date(String hrdis_date){this.hrdis_date = hrdis_date;}

    public String getHrdis_result() {return hrdis_result;}
    public void setHrdis_result(String hrdis_result){this.hrdis_result = hrdis_result;}

    public String getHrdis_type() {return hrdis_type;}
    public void setHrdis_type(String hrdis_type){this.hrdis_type = hrdis_type;}

    public int getAcc_id() {return  acc_id;}
    public void setAcc_id(int acc_id){this.acc_id = acc_id;}
}



