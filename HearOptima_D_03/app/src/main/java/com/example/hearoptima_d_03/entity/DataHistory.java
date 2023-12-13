package com.example.hearoptima_d_03.entity;

import static com.example.hearoptima_d_03.global.TConst.DB_FILE;
import static com.example.hearoptima_d_03.global.TConst.DB_VER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hearoptima_d_03.db.SQLiteHelper;

import java.util.ArrayList;

public class DataHistory {

    String m_TAG = "DataHistory";

    SQLiteDatabase m_database;
    SQLiteHelper m_helper;
    Context m_Context = null;
    String m_PackageName = "";
    ArrayList<HrDataInfoSet> sets = new ArrayList<>();
    ArrayList<HrDataInfoUnit> units = new ArrayList<>();

    public DataHistory(Context context){
        this.m_Context = context;
        this.m_PackageName = m_Context.getPackageName();
        m_helper = new SQLiteHelper(m_Context, DB_FILE, null, DB_VER);
    }

    public void closeDatabase(){
        try {
            m_database.close();
            m_helper.close();
        } catch (Exception e){
        }
    }
//
//    public ArrayList<HrDataInfoSet> searchHrDataInfoSet(){
//        int acc_id = GlobalVar.g_AccLogin.getAcc_id();
//        sets = selectDataInfoSetFromId(acc_id);
//        if(sets != null){
//            return sets;
//        }else {
//            return null;
//        }
//    }
//
//    public ArrayList<HrDataInfoUnit> searchHrDataInfoUnit(){
//        units = selectDataInfoUnitFrom
//    }
}
