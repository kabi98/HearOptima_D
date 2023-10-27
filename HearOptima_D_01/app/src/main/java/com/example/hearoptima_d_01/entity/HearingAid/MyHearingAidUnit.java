package com.example.hearoptima_d_01.entity.HearingAid;

public class MyHearingAidUnit {
    int mhau_id;
    int mhau_right_ACT;
    int mhau_right_BCT;
    int mhau_right_WRS;
    int mhau_left_ACT;
    int mhau_left_BCT;
    int mhau_left_WRS;
    int mhag_id;

    public MyHearingAidUnit(){
    }

    public MyHearingAidUnit(int mhau_id, int mhag_id, int mhau_right_ACT, int mhau_right_BCT, int mhau_right_WRS, int mhau_left_ACT, int mhau_left_BCT, int mhau_left_WRS){
        this.mhau_id = mhau_id;
        this.mhag_id = mhag_id;
        this.mhau_right_ACT = mhau_right_ACT;
        this.mhau_right_BCT = mhau_right_BCT;
        this.mhau_right_WRS = mhau_right_WRS;
        this.mhau_left_ACT = mhau_left_ACT;
        this.mhau_left_BCT = mhau_left_BCT;
        this.mhau_left_WRS = mhau_left_WRS;
    }

    public MyHearingAidUnit(int mhag_id, int mhau_right_ACT, int mhau_right_BCT, int mhau_right_WRS, int mhau_left_ACT, int mhau_left_BCT, int mhau_left_WRS){
        this.mhag_id = mhag_id;
        this.mhau_right_ACT = mhau_right_ACT;
        this.mhau_right_BCT = mhau_right_BCT;
        this.mhau_right_WRS = mhau_right_WRS;
        this.mhau_left_ACT = mhau_left_ACT;
        this.mhau_left_BCT = mhau_left_BCT;
        this.mhau_left_WRS = mhau_left_WRS;
    }

    public int getMhau_id(){return mhau_id;}
    public void setMhau_id(int mhau_id){this.mhau_id = mhau_id;}
    public int getMhag_id(){return mhag_id;}
    public void setMhag_id(int mhag_id){this.mhag_id = mhag_id;}
    public int getMhau_right_ACT(){return mhau_right_ACT;}
    public void setMhau_right_ACT(int mhau_right_ACT){this.mhau_right_ACT = mhau_right_ACT;}
    public int getMhau_right_BCT(){return mhau_right_BCT;}
    public void setMhau_right_BCT(int mhau_right_BCT){this.mhau_right_BCT = mhau_right_BCT;}
    public int getMhau_right_WRS(){return mhau_right_WRS;}
    public void setMhau_right_WRS(int mhau_right_WRS){this.mhau_right_WRS = mhau_right_WRS;}
    public int getMhau_left_ACT(){return mhau_left_ACT;}
    public void setMhau_left_ACT(int mhau_left_ACT){this.mhau_left_ACT = mhau_left_ACT;}
    public int getMhau_left_BCT(){return mhau_left_BCT;}
    public void setMhau_left_BCT(int mhau_left_BCT){this.mhau_left_BCT = mhau_left_BCT;}
    public int getMhau_left_WRS(){return mhau_left_WRS;}
    public void setMhau_left_WRS(int mhau_left_WRS){this.mhau_left_WRS = mhau_left_WRS;}
}
