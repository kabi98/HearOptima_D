package com.example.hearoptima_d_01.views.HearingAidFind;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hearoptima_d_01.R;
import com.example.hearoptima_d_01.db.SQLiteControl;
import com.example.hearoptima_d_01.db.SQLiteHelper;
import com.example.hearoptima_d_01.entity.HraidImage;
import com.example.hearoptima_d_01.entity.HraidInfoImage;

public class HearingAidGoodsInfoActivity extends AppCompatActivity {

    SQLiteControl m_SqlCon = null;
    SQLiteHelper helper;
    SQLiteDatabase sqlite;

    private ImageView aidGoodsImage, aidGoodsImageInfo;
    private TextView aidBrand, aidShape, aidName, aidPrice;
    private SQLiteControl sqliteControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_aid_goods_info);

        aidGoodsImage = findViewById(R.id.AidgoodsImage);
        aidGoodsImageInfo = findViewById(R.id.AidgoodsImageInfo);
        aidBrand = findViewById(R.id.Aidbrand);
        aidShape = findViewById(R.id.Aidshape);
        aidName = findViewById(R.id.Aidname);
        aidPrice = findViewById(R.id.Aidprice);

        m_SqlCon = new SQLiteControl(this);

        long ha_id = 40; // ha_id 1에 대한 데이터를 가져온다고 가정
        Cursor cursor = m_SqlCon.getData(ha_id);
        if (cursor != null && cursor.moveToFirst()) {
            int ha_nameIndex = cursor.getColumnIndex("ha_name");
            int ha_typeIndex = cursor.getColumnIndex("ha_type");
            int ha_max_priceIndex = cursor.getColumnIndex("ha_max_price");
            int ha_brandIndex = cursor.getColumnIndex("ha_brand");
            int hri_idIndex = cursor.getColumnIndex("hri_id");
            int hrii_idIndex = cursor.getColumnIndex("hrii_id");
            int hri_file_nameIndex = cursor.getColumnIndex("hri_file_name");
            int hrii_file_nameIndex = cursor.getColumnIndex("hrii_file_name");


            String ha_name = ha_nameIndex != -1 ? cursor.getString(ha_nameIndex) : null;
            String ha_type = ha_typeIndex != -1 ? cursor.getString(ha_typeIndex) : null;
            String ha_max_price = ha_max_priceIndex != -1 ? cursor.getString(ha_max_priceIndex) : null;
            String ha_brand = ha_brandIndex != -1 ? cursor.getString(ha_brandIndex) : null;
            int hri_id = hri_idIndex != -1 ? cursor.getInt(hri_idIndex) : -1; // -1이면 컬럼이 존재하지 않음을 의미
            int hrii_id = hrii_idIndex != -1 ? cursor.getInt(hrii_idIndex) : -1;
            String hri_file_name = hri_file_nameIndex != -1 ? cursor.getString(hri_file_nameIndex) : null;
            String hrii_file_name = hrii_file_nameIndex != -1 ? cursor.getString(hrii_file_nameIndex) : null;

            // 뷰에 데이터 설정
            aidName.setText(ha_name);
            aidShape.setText(ha_type);
            aidPrice.setText(ha_max_price);
            aidBrand.setText(ha_brand);
            if (hri_file_name != null) {
                // hri_file_name에 대한 리소스 ID 가져오기
                int resourceId = getResources().getIdentifier(hri_file_name, "drawable", getPackageName());

                // hri_file_name 이미지를 aidsImage에 설정
                if (resourceId != 0) {
                    aidGoodsImage.setBackgroundResource(resourceId);
                } else {
                    // 유효하지 않은 경우, 기본 이미지나 오류 처리
                }
            }

            if (hrii_file_name != null) {
                // hrii_file_name에 대한 리소스 ID 가져오기
                int resourceIdInfo = getResources().getIdentifier(hrii_file_name, "drawable", getPackageName());

                // hrii_file_name 이미지를 aidsInfoImage에 설정
                if (resourceIdInfo != 0) {
                    aidGoodsImageInfo.setBackgroundResource(resourceIdInfo);
                } else {
                    // 유효하지 않은 경우, 기본 이미지나 오류 처리
                }
            }
            cursor.close();
        }
    }
}