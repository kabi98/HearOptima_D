package com.example.hearoptima_d_03.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hearoptima_d_03.entity.FilterDTO;
import com.example.hearoptima_d_03.entity.MyHearingAidGroup;
import com.example.hearoptima_d_03.entity.HraidImage;
import com.example.hearoptima_d_03.entity.Utils.Account;
import com.example.hearoptima_d_03.entity.Filter;
import com.example.hearoptima_d_03.entity.HearingAid;

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
        Log.v("SQLiteControl", "selectFilterHearingAid");

        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            StringBuilder strSQL = new StringBuilder("SELECT ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id FROM hearing_aid");
            ArrayList<Filter> shapes = dto.getShapes();
            ArrayList<Filter> brands = dto.getBrands();
            int minPrice = dto.getMinPrice();
            int maxPrice = dto.getMaxPrice();

            boolean hasShapeFilters = shapes != null && !shapes.isEmpty();
            boolean hasBrandFilters = brands != null && !brands.isEmpty();
            boolean hasPriceFilters = (minPrice >= 0) && (maxPrice > 0);

            // Adding WHERE clause if any filter is applied
            boolean anyFilterApplied = hasShapeFilters || hasBrandFilters || hasPriceFilters;
            if (anyFilterApplied) {
                strSQL.append(" WHERE ");

                if (hasShapeFilters) {
                    strSQL.append(" ( ");
                    for (int i = 0; i < shapes.size(); i++) {
                        strSQL.append(i != 0 ? " OR " : "");
                        strSQL.append("ha_type = '").append(shapes.get(i).getValue()).append("'");
                    }
                    strSQL.append(" ) ");
                }

                if (hasBrandFilters) {
                    if (hasShapeFilters) strSQL.append(" AND ");
                    strSQL.append(" ( ");
                    for (int i = 0; i < brands.size(); i++) {
                        strSQL.append(i != 0 ? " OR " : "");
                        strSQL.append("ha_brand = '").append(brands.get(i).getValue()).append("'");
                    }
                    strSQL.append(" ) ");
                }

                if (hasPriceFilters) {
                    if (hasShapeFilters || hasBrandFilters) strSQL.append(" AND ");
                    strSQL.append(" (ha_max_price BETWEEN ").append(minPrice).append(" AND ").append(maxPrice).append(") ");
                }
            }


            strSQL.append(";");
            Log.v("SQLiteControl", strSQL.toString());
            Cursor cursor = sqlite.rawQuery(strSQL.toString(), null);
            Log.v("SQLiteControl", String.format("selectFilterHearingAid Result = %d", cursor.getCount()));

            if (cursor.getCount() <= 0) {
                cursor.close();
                return aids;
            }

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int ha_id = cursor.getInt(0);
                String ha_name = cursor.getString(1);
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

                HearingAid aidOne = new HearingAid(ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id);
                aids.add(aidOne);
            }
            cursor.close();
        } catch (Exception e) {
            Log.e("SQLiteControl", "Error in selectFilterHearingAid: " + e.getMessage());
            return null;
        }
        return aids;
    }

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
    }
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
    }
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
    }
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
    }
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
    }

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
            String phone = cursor.getString(2);
            String pwd = cursor.getString(3);
            String name = cursor.getString(4);
            String gender = cursor.getString(5);
            String birth = cursor.getString(6);

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
    public Cursor getData(long ha_id) {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.rawQuery(
                "SELECT * FROM hearing_aid " +
                        "JOIN hraid_image ON hearing_aid.hri_id = hraid_image.hri_id " +
                        "JOIN hraid_inform_image ON hearing_aid.hrii_id = hraid_inform_image.hrii_id " +
                        "WHERE hearing_aid.ha_id = " + ha_id, null);
        return cursor;

    }
    // 사용자 입력에 따라 검색하는 함수
    public Cursor getHearingAidsWithName(String searchName) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = " SELECT * FROM hearing_aid "
                + " WHERE ha_name LIKE ? "
                + " or ha_brand LIKE ? "
                + " or ha_type LIKE ? ";

        String  strParam[] = {"%" + searchName + "%", "%" + searchName + "%", "%" + searchName + "%"};
        return db.rawQuery(query, strParam);
    }


    public ArrayList<HearingAid> selectFromKeyWord(String strKeyWord) {
        Log.v("SQLiteControl", "selectFromKeyWord");

        ArrayList<HearingAid> aids = new ArrayList<>();
        try {
            sqlite = helper.getReadableDatabase();

            String strSQL = "  SELECT ha_id,ha_name,ha_type,ha_brand,ha_bluetooth,ha_content, "
                    +" ha_insurance,ha_min_price,ha_max_price,ha_etc,hri_id,hrii_id "
                    +" from hearing_aid "
                    + " WHERE ha_name LIKE ? "
                    + " or ha_brand LIKE ? "
                    + " or ha_type LIKE ? ";
            String  strParam[] = {"%" + strKeyWord + "%", "%" + strKeyWord + "%", "%" + strKeyWord + "%"};

            Cursor cursor = sqlite.rawQuery(strSQL, strParam);

            Log.v("SQLiteControl",
                    String.format("selectAllHearingAid Result = %d", cursor.getCount()));
            if (cursor.getCount() <= 0) {
                cursor.close();
                return null;
            }

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
    }

/*
    Cursor cursor = m_SqlCon.getHearingAidsWithName(strHearingAidName);
                Log.v("HearingAidNameSearch", "cursor " + cursor );

                if(cursor != null){
        Log.v("HearingAidNameSearch", "cursor count " + cursor.getCount());

        if(cursor.getCount() <= 0) {
            cursor.close();
            return;
        }

        for(int i=0; i<cursor.getCount(); i++){
            cursor.moveToNext();
            int ha_nameIndex = cursor.getColumnIndex("ha_name");
            int ha_brandIndex = cursor.getColumnIndex("ha_brand");

            String str_ha_name = cursor.getString(ha_nameIndex);
            String str_ha_brand = ha_brandIndex != -1 ? cursor.getString(ha_brandIndex) : null;
            Log.v("HearingAidNameSearch", String.format("HearingAidNameSearch name:%s, brand:%s", str_ha_name, str_ha_brand));
        }

*/

    }
