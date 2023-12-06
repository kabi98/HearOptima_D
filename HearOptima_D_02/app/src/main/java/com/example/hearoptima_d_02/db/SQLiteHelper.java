package com.example.hearoptima_d_02.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.hearoptima_d_02.global.TConst;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SQLiteHelper extends android.database.sqlite.SQLiteOpenHelper{
    String m_TAG = "SQLiteHelper";

    Context m_Context = null;

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.v("SQLiteHelper", "SQLiteHelper() ver : " + version);
        this.m_Context = context;
        checkDatabaseAndCopy();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("SQLiteHelper", "onCreate()");

        String sql_Temp = "";


        sql_Temp = " CREATE TABLE IF NOT EXISTS account ( "
                + " acc_id INTEGER PRIMARY KEY  AUTOINCREMENT "
                + " , acc_phone_id  TEXT UNIQUE NOT NULL "
                + " , acc_phone TEXT "
                + " , acc_pwd   TEXT "
                + " , acc_name  TEXT"
                + " , acc_gender TEXT "
                + " , acc_birth TEXT "
                + " ); ";

        db.execSQL(sql_Temp);

        Log.v("SQLiteHelper", "onCreate() - Finish");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("SQLiteHelper", "onUpgrade() old : " + oldVersion
                + " new : " + newVersion);

        db.execSQL(" drop table IF EXISTS account; ");

        onCreate(db);

        Log.v("SQLiteHelper", "onUpgrade() - Finish");

    }

    //------------------------------------ DATABASES FOLDERS FILE CHECK -------------------------//
    private void checkDatabaseAndCopy(){
        // 해당 폴더(경로 : DATABASES 폴더 하위에 DATABASE_NAME과 같은 데이터베이스가 있는지 체크
        String DB_PATH = "/data/data/" + m_Context.getPackageName() + "/databases/";
        File dbFile = new File(DB_PATH + TConst.DB_FILE);
        if(!dbFile.exists()){
            // 파일이 존재 하지 않을 때 dbCopy 메소드를 실행
            copyDatabaseFileFromAssets();
            // 복사 완료후 Log로 확인
            Log.v(m_TAG,"DataBase is Copied");
        }
    }

    //------------------------------------ DATABASES COPY METHOD ---------------------------------//
    private void copyDatabaseFileFromAssets(){

        try{
            String DB_PATH = "/data/data/" + m_Context.getPackageName() + "/databases/";
            File folder = new File(DB_PATH);
            if(!folder.exists()){
                folder.mkdir();
            }

            InputStream inputStream = m_Context.getAssets().open(TConst.DB_FILE);
            String out_filename =DB_PATH+TConst.DB_FILE;
            OutputStream outputStream = new FileOutputStream(out_filename);

            int iLen;
            byte[] byteBuf = new byte[inputStream.available()];
            while((iLen = inputStream.read(byteBuf)) != -1) {
                outputStream.write(byteBuf, 0, iLen);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            outputStream = null;
            inputStream = null;

        } catch (IOException e) {
            Log.v(m_TAG,"copyDatabaseFileFromAssets Exception : " + e.toString());
            throw new RuntimeException(e);

        }
    }


}
