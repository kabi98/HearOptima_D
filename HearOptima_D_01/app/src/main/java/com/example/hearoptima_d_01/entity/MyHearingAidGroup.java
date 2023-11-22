package com.example.hearoptima_d_01.entity;

public class MyHearingAidGroup {
    int mhag_id;
    String mhag_date;
    String mhag_result;
    String mhag_type;
    int acc_id;

    public MyHearingAidGroup(){
    }

    public MyHearingAidGroup(int mhag_id, String mhag_date, String mhag_reuslt, String mhag_type, int acc_id){
        this.mhag_id = mhag_id;
        this.mhag_date = mhag_date;
        this.mhag_result = mhag_reuslt;
        this.mhag_type = mhag_type;
        this.acc_id = acc_id;
    }

    @Override
    public String toString(){
        return "MyHearingAidGroup{" +
                "mhag_id=" + mhag_id +
                ", mhag_date='" + mhag_date + '\'' +
                ", mhag_result='" + mhag_result + '\'' +
                ", mhag_type='" + mhag_type + '\'' +
                ", acc_id=" + acc_id +
                '}';
    }

    public int getMhag_id() { return mhag_id;}

    public void setMhag_id(int mhag_id) {this.mhag_id = mhag_id;}

    public String getMhag_date() {
        return mhag_date;
    }

    public void setMhag_date(String mhag_date) {
        this.mhag_date = mhag_date;
    }

    public String getMhag_result() {
        return mhag_result;
    }

    public void setMhag_result(String mhag_result) {
        this.mhag_result = mhag_result;
    }

    public String getMhag_type() {
        return mhag_type;
    }

    public void setMhag_type(String mhag_type) {
        this.mhag_type = mhag_type;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

}
