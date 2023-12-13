package com.example.hearoptima_d_03.entity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hearoptima_d_03.db.SQLiteHelper;
import com.example.hearoptima_d_03.entity.Utils.Account;
import com.example.hearoptima_d_03.global.TConst;

import java.util.ArrayList;

public class DataInputDAO {
    String m_TAG = "DataInputDAO";
    Context m_Context;
    SQLiteDatabase m_database;
    SQLiteHelper m_helper;
    boolean m_isMyDatabase = false;
    Account m_Account;
    HrDataInfoSet m_HrDataInnfoSet;
    HrDataInfoUnit m_HrDataInfoUnit;
    ArrayList<HrDataInfoUnit> m_DataInputList;
    HrDataInfoUnit m_DataInfoUnit;
    HrDataInfoSet m_DataInfoSet;

    public DataInputDAO(SQLiteHelper m_helper){
        m_isMyDatabase = false;
        this.m_helper = m_helper;
    }

    public DataInputDAO(Context _context) {
        m_isMyDatabase = true;
        m_Context = _context;
        m_helper = new SQLiteHelper(m_Context, TConst.DB_FILE, null, TConst.DB_VER);
    }

    public void releaseAndClose() {
        try {
            if(m_isMyDatabase){
                m_database.close();
                m_helper.close();
            }
        } catch (Exception e) {
        }
    }

    public HrDataInfoSet insertAndSelectDataInfoSet(HrDataInfoSet disIns){
        try {
            tryInsertDataInfoSet(disIns);
            return selectDataInfoSet(disIns);
        } catch (Exception e){
            return null;
        }
    }

    private void tryInsertDataInfoSet(HrDataInfoSet disIns){
        m_database = m_helper.getWritableDatabase();
        String strSQL = " INSERT INTO hrdi_set (hrdis_date, hrdis_result, hrdis_type, acc_id)"
                + " VALUES (?, ?, ?, ?)";
        Object[] params = {disIns.getHrdis_id(), disIns.getHrdis_date(), disIns.getHrdis_result(), disIns.getHrdis_type(), disIns.getAcc_id()};
        m_database.execSQL(strSQL, params);
    }

    public HrDataInfoSet selectDataInfoSet(HrDataInfoSet disInput){
        try {
            return trySelectDataInfoSet(disInput);
        }catch (Exception e){
            return null;
        }
    }

    private HrDataInfoSet trySelectDataInfoSet(HrDataInfoSet disInput){
        m_database = m_helper.getReadableDatabase();
        String strSQL = " SELECT hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id"
                + "FROM hrdi_set WHERE hrdis_date= ? and hrdis_type= ? and acc_id = ?;";
        String[] params = {disInput.getHrdis_date(), disInput.getHrdis_type(), Integer.toString(disInput.getAcc_id())};
        Cursor cursor = m_database.rawQuery(strSQL, params);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            int     hrdis_id        = cursor.getInt(0);
            String  hrdis_date      = cursor.getString(1);
            String  hrdis_result    = cursor.getString(2);
            String  hrdis_type      = cursor.getString(3);
            int     acc_id          = cursor.getInt(4);

            HrDataInfoSet disOne = new HrDataInfoSet(hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id);

            cursor.close();
            return disOne;
        } else {
            return null;
        }
    }

    public HrDataInfoUnit insertDataInfoUnit(HrDataInfoUnit diuInsert) {
        try {
            tryInsertDataInfoUnit(diuInsert);
            return selectDataInfoUnit(diuInsert);
        } catch (Exception e) {
            return null;
        }
    }

    public void tryInsertDataInfoUnit(HrDataInfoUnit diuInsert){
        m_database = m_helper.getWritableDatabase();

        String strSQL = " INSERT INTO hrdi_unit (hrdis_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?);";
        Object[] params = {diuInsert.getHrdis_id(), diuInsert.getHrdiu_right_ACT(), diuInsert.getHrdiu_right_BCT(), diuInsert.getHrdiu_right_WRS(), diuInsert.getHrdiu_left_ACT(), diuInsert.getHrdiu_left_BCT(), diuInsert.getHrdiu_left_WRS()};
        m_database.execSQL(strSQL, params);
    }

    public HrDataInfoUnit selectDataInfoUnit(HrDataInfoUnit diuInput){
        try {
            return trySelectDataInfoUnit(diuInput);
        } catch (Exception e){
            return null;
        }
    }

    public HrDataInfoUnit trySelectDataInfoUnit(HrDataInfoUnit diuInput){
        m_database = m_helper.getReadableDatabase();
        String strSQL = " SELECT hrdiu_id, hrdis_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS"
                + "FROM hrdi_unit WHERE hrdis_id = ?;";
        String[] params = { Integer.toString(diuInput.getHrdiu_id())};
        Cursor cursor = m_database.rawQuery(strSQL, params);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            int     hrdiu_id        = cursor.getInt(0);
            int     hrdis_id        = cursor.getInt(1);
            int     hrdiu_right_ACT = cursor.getInt(2);
            int     hrdiu_right_BCT = cursor.getInt(3);
            int     hrdiu_right_WRS = cursor.getInt(4);
            int     hrdiu_left_ACT  = cursor.getInt(5);
            int     hrdiu_left_BCT  = cursor.getInt(6);
            int     hrdiu_left_WRS  = cursor.getInt(7);

            HrDataInfoUnit diuOne = new HrDataInfoUnit(hrdiu_id, hrdis_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS);
            cursor.close();

            return diuOne;
        } else {
            return null;
        }
    }

    public HrDataInfoUnit selectDataInfoUnitFromDataInfoSet(int iDisId){
        try {
            return tryselectDataInfoUnitFromDataInfoSet(iDisId);
        } catch (Exception e){
            return null;
        }
    }

    private HrDataInfoUnit tryselectDataInfoUnitFromDataInfoSet(int iDisId){
        m_database = m_helper.getReadableDatabase();
        String strSQL = "SELECT hrdiu_id, hrdis_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS"
                + "FROM hrdi_unit WHERE hrdis_id = ?;";
        String[] params = {Integer.toString(iDisId)};
        Cursor cursor = m_database.rawQuery(strSQL, params);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            int hrdiu_id        = cursor.getInt(0);
            int hrdis_id        = cursor.getInt(1);
            int hrdiu_right_ACT = cursor.getInt(2);
            int hrdiu_right_BCT = cursor.getInt(3);
            int hrdiu_right_WRS = cursor.getInt(4);
            int hrdiu_left_ACT  = cursor.getInt(5);
            int hrdiu_left_BCT  = cursor.getInt(6);
            int hrdiu_left_WRS  = cursor.getInt(7);

            HrDataInfoUnit diuOne = new HrDataInfoUnit(hrdiu_id, hrdis_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS);
            cursor.close();

            return diuOne;
        } else {
            return null;
        }
    }

    private HrDataInfoSet trySelectDataInfoSetFromDisId(int iDisId){
        m_database = m_helper.getReadableDatabase();

        String strSQL = " SELECT hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id"
                + "FROM hrdi_set WHERE hrdis_id= ?;";
        String[] params = {Integer.toString(iDisId)};
        Cursor cursor = m_database.rawQuery(strSQL, params);

        if (cursor.getCount() > 0){
            cursor.moveToNext();

            int     hrdis_id        = cursor.getInt(0);
            String  hrdis_date      = cursor.getString(1);
            String  hrdis_result    = cursor.getString(2);
            String  hrdis_type      = cursor.getString(3);
            int     acc_id          = cursor.getInt(4);

            HrDataInfoSet disOne = new HrDataInfoSet(hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id);
            cursor.close();

            return disOne;
        } else {
            return null;
        }
    }
    public void insertAndSelectDataInfoUnit(){
        DataInputDAO hrDataInfoDAO = new DataInputDAO(m_helper);
        m_DataInfoUnit.setHrdis_id(m_DataInfoSet.getHrdis_id());
        hrDataInfoDAO.insertDataInfoUnit(m_DataInfoUnit);
        m_DataInfoUnit = hrDataInfoDAO.selectDataInfoUnit(m_DataInfoUnit);
        Log.v(m_TAG, "saveDataInfoUnit");
    }

    public void saveDataInput(){
        insertAndSelectDataInfoUnit();
    }
}
