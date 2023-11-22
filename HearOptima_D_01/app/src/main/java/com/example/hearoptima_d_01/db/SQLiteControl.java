package com.example.hearoptima_d_01.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hearoptima_d_01.entity.FilterDTO;
import com.example.hearoptima_d_01.entity.MyHearingAidGroup;
import com.example.hearoptima_d_01.entity.HraidImage;
import com.example.hearoptima_d_01.entity.Utils.Account;
import com.example.hearoptima_d_01.entity.FilterDTO;
import com.example.hearoptima_d_01.entity.Filter;
import com.example.hearoptima_d_01.entity.HearingAid;
import com.example.hearoptima_d_01.entity.HraidImage;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SQLiteControl {
    String m_TAG = "SQLiteControl";
    SQLiteHelper helper;
    SQLiteDatabase sqlite;

    public SQLiteControl(SQLiteHelper _helper){
        this.helper = _helper;
    }

    public void db_close(){
        try {
            sqlite.close();
            helper.close();
        }catch (Exception e){
            Log.v(m_TAG, "db_close Exception" + e);
        }
    }

    public ArrayList<HearingAid> selectFilterHearingAid(FilterDTO dto) {
        Log.v("SQLiteControl", "selectOrderByDescName");

        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid ";
            strSQL += " where ";

            ArrayList<Filter> shapes = dto.getShapes();
            Log.v("TEST LOG","SQL shapes VALUES : " + shapes.toString());
            strSQL += " ( ";
            for(int i=0; i<shapes.size(); i++){

                if(i!=0){
                    strSQL += " OR ";
                }
                strSQL += " ha_type == '"+shapes.get(i).getValue()+"'";
            }
            strSQL += ") AND (";
            ArrayList<Filter> brands = dto.getBrands();
            Log.v("TEST LOG","SQL BRANDS VALUES : " + brands.toString());
            for(int i=0; i<brands.size(); i++){
                if(i!=0){
                    strSQL += " OR ";
                }
                strSQL += " ha_brand == '"+brands.get(i).getValue()+"'";
            }
            strSQL += " ) ;";

            Log.v("SQLiteControl",strSQL);
            Cursor cursor = sqlite.rawQuery(strSQL, null);
            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);
            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };

    public HraidImage selectImageFile(int _hri_id){
        try{
            sqlite = helper.getWritableDatabase();
            String strSQL = " select hri_id, hri_file_name,hri_file_ext,hri_content from hraid_image "
                    + " WHERE hri_id = ? ; ";
            String[] params = {Integer.toString(_hri_id)};
            Cursor cursor = sqlite.rawQuery(strSQL,params);
            if (cursor.getCount() > 0){
                Log.v("TEST LOG","value : "+  cursor.getCount());
                cursor.moveToNext();
                int hri_id = cursor.getInt(0);
                String hri_file_name = cursor.getString(1);
                String hri_file_ext = cursor.getString(2);
                String hri_content = cursor.getString(3);
                HraidImage hraidImage = new HraidImage(hri_id,hri_file_name,hri_file_ext,hri_content);
                cursor.close();
                return hraidImage;
            }
        }catch (Exception e) {
            return null;
        }
        return null;


    }
    //----------------------------------------이름 오름 차순----------------------------------------//
    public ArrayList<HearingAid> selectOrderByAscName() {
        Log.v("SQLiteControl", "selectOrderByDescName");


        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid order by ha_name Desc ; ";
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);
            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };
    //----------------------------------------이름 내림 차순----------------------------------------//

    //----------------------------------------이름 내름 차순----------------------------------------//
    public ArrayList<HearingAid> selectOrderByDescName() {
        Log.v("SQLiteControl", "selectOrderByDescName");


        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid order by ha_name Desc ; ";
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);
            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };
    //----------------------------------------이름 내림 차순----------------------------------------//




    //----------------------------------------가격 오름 차순----------------------------------------//
    public ArrayList<HearingAid> selectOrderByAscPrice() {
        Log.v("SQLiteControl", "selectOrderByAscPrice");


        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid order by ha_max_price asc ; ";
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);
            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };
    //----------------------------------------가격 오름 차순----------------------------------------//
    //----------------------------------------가격 내름 차순----------------------------------------//
    public ArrayList<HearingAid> selectOrderByDescPrice() {
        Log.v("SQLiteControl", "selectOrderByAscPrice");


        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid order by ha_max_price Desc ; ";
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);
            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };
    //----------------------------------------가격 오름 차순----------------------------------------//
    public ArrayList<HearingAid> selectAllHearingAid() {
        Log.v("SQLiteControl", "selectAllHearingAid");


        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id from hearing_aid ; ";
            Cursor cursor = sqlite.rawQuery(strSQL, null);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0)
                return null;

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name= cursor.getString(1);
                String ha_type = cursor.getString(2);
                String ha_brand = cursor.getString(3);
                String ha_bluetooth = cursor.getString(4);
                String ha_content = cursor.getString(5);
                String ha_insurance = cursor.getString(6);
                int ha_min_price = cursor.getInt(7);
                int ha_max_price = cursor.getInt(8);
                String ha_etc = cursor.getString(9);
                int hri_id = cursor.getInt(10);
                int hrii_id = cursor.getInt(11);

                HearingAid aidOne = new HearingAid(ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content,ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id);

                aids.add(aidOne);


            }
            cursor.close();
            return aids;

        } catch (Exception e) {
            return null;
        }
    };

    public Account selectLogin(String strPhonId, String strPwd){
        Log.v(m_TAG, String.format("selectLogin strPhone %s, Pass %s", strPhonId, strPwd));
        try {
            return trySelectLogin(strPhonId, strPwd);
        }catch (Exception e){
            Log.v(m_TAG, "selectLogin Exception " +e);
            return null;
        }
    }
    public Account test(String textid, String textpw){
        sqlite = helper.getReadableDatabase();
        try {
            String strSQL = " SELECT acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth "
                    + " FROM account WHERE acc_phone_id= ? and acc_pwd = ?; ";
            String[] params = { textid, textpw};
            Cursor cursor = sqlite.rawQuery(strSQL, params);
            if(cursor.getCount()<=0) {
                return null;
            }else{

                int id = cursor.getInt(0);
                String acc_phone_id = cursor.getString(1);
                String acc_phone = cursor.getString(2);
                String acc_pwd = cursor.getString(3);
                String acc_name = cursor.getString(4);
                String acc_gender = cursor.getString(5);
                String acc_birth = cursor.getString(6);
                Account account = new Account(id,acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth);
                return account;
            }
        } catch (Exception e){
            Log.v(m_TAG, "insertAccount Exception " + e);
            return null;
        }
    }
    public Account trySelectLogin(String strPhoneId, String strPwd){
        sqlite = helper.getReadableDatabase();

        String strSQL = " SELECT acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth"
                + "FROM account WHERE acc_phone_id= ? and acc_pwd = ?; ";
        String[] params = { strPhoneId, strPwd};
        Cursor cursor = sqlite.rawQuery(strSQL, params);

        Log.v(m_TAG, String.format("trySelectLogin Result = %d", cursor.getCount()));

        if (cursor.getCount()> 0){
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String phone_id = cursor.getString(1);
            String phone = cursor.getString(1);
            String pwd = cursor.getString(1);
            String name = cursor.getString(1);
            String gender = cursor.getString(1);
            String birth = cursor.getString(1);

            Account accOne = new Account(id, phone_id, phone, pwd, name, gender, birth);

            Log.v(m_TAG, accOne.toString());
            cursor.close();

            return accOne;
        } else {
            return null;
        }
    }

    public int insertAccount(Account acInsert){
        Log.v(m_TAG, String.format("insertAccount acInsert : %s"));

        try {
            sqlite = helper.getWritableDatabase();
            String strSQL = " INSERT INTO account (acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth) "
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            Object[] params = {acInsert.getAcc_phone_id(), acInsert.getAcc_phone(),
            acInsert.getAcc_pwd(), acInsert.getAcc_name(),
            acInsert.getAcc_gender(), acInsert.getAcc_birth()};

            sqlite.execSQL(strSQL, params);
        } catch (Exception e){
            Log.v(m_TAG, "insertAccount Exception " + e);
            return -1;
        }
        return 1;
    }

    public MyHearingAidGroup selectMyHearingAidGroup(MyHearingAidGroup HraidInput){
        Log.v(m_TAG, String.format("selectMyHearingAidGroup Date %s, Result %s, Type %s, Id %d", HraidInput.getMhag_date(), HraidInput.getMhag_result(), HraidInput.getMhag_type(), HraidInput.getMhag_id()));

        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = " SELECT mhag_id, mhag_date, mhag_result, mhag_type, acc_id"
                    + "FROM myhraid_group WHERE mhag_date= ? and mhag_result= ? and mhag_type= ? and acc_id= ?; ";
            String[] params = {HraidInput.getMhag_date(), HraidInput.getMhag_result(), HraidInput.getMhag_type(), Integer.toString(HraidInput.getAcc_id())};
            Cursor cursor = sqlite.rawQuery(strSQL, params);

            if(cursor.getCount() > 0){
                cursor.moveToNext();

                int mhag_id = cursor.getInt(0);
                String mhag_date = cursor.getString(1);
                String mhag_result = cursor.getString(2);
                String mhag_type = cursor.getString(3);
                int acc_id = cursor.getInt(4);

                MyHearingAidGroup mhagOne = new MyHearingAidGroup(mhag_id, mhag_date, mhag_result, mhag_type, acc_id);

                cursor.close();
                return mhagOne;
            }else {
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public int insertMyHearingAidGroup(MyHearingAidGroup hraidInsert){
        Log.v(m_TAG, "insertMyHearingAidGroup");
        try{
            sqlite = helper.getWritableDatabase();
            String strSQL = " INSERT INTO myhraid_group (mhag_date, mhag_result, mhag_type, acc_id)"
                    + " VALUES (?, ?, ?, ?)";
            Object[] params = {hraidInsert.getMhag_date(), hraidInsert.getMhag_result(), hraidInsert.getMhag_type(), hraidInsert.getAcc_id()};
            sqlite.execSQL(strSQL, params);
        } catch (Exception e){
            Log.v(m_TAG, "insertMyHearingAidGroup Exception" + e);
            return -1;
        }
        return 1;
    }

    public ArrayList<MyHearingAidGroup> selectMyHearingAidGroupFromId(int acc_id){
        ArrayList<MyHearingAidGroup> MyHearingAidGroup = new ArrayList<>();
        Log.v(m_TAG,
                String.format("selectMyHearingAidGroupFromId Id : %d", acc_id));
        try {
            sqlite = helper.getReadableDatabase();
            String strSQL = " SELECT mhag_id, mhag_date, mhag_result, mhag_type, acc_id"
                    + " FROM myhraid_group WHERE acc_id = ?"
                    + "ORDER BY mhag_id desc ;";
            String[] params = {Integer.toString(acc_id)};
            Cursor cursor = sqlite.rawQuery(strSQL, params);
            Log.v(m_TAG,
                    String.format("selectMyHearingAidGroup Result = %d", cursor.getCount()));
            if(cursor.getCount() <= 0)
                return null;
            for(int i=0; i<cursor.getCount(); i++){
                cursor.moveToNext();
                int mhag_id = cursor.getInt(0);
                String mhag_date = cursor.getString(1);
                String mhag_result = cursor.getString(2);
                String mhag_type = cursor.getString(3);
                int mhagAcc_id = cursor.getInt(4);
                MyHearingAidGroup mhagOne = new MyHearingAidGroup(mhag_id, mhag_date, mhag_result, mhag_type, mhagAcc_id);
                MyHearingAidGroup.add(mhagOne);
            }
            cursor.close();
            return MyHearingAidGroup;
        } catch (Exception e){
            Log.v(m_TAG, "selectMyHearingAidGroup Exception " + e);
            return null;
        }
    }
}
