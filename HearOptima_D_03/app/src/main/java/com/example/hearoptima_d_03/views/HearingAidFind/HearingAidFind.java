package com.example.hearoptima_d_03.views.HearingAidFind;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearoptima_d_03.R;
import com.example.hearoptima_d_03.db.SQLiteControl;
import com.example.hearoptima_d_03.db.SQLiteHelper;
import com.example.hearoptima_d_03.entity.AidsView;
import com.example.hearoptima_d_03.entity.Filter;
import com.example.hearoptima_d_03.entity.FilterDTO;
import com.example.hearoptima_d_03.entity.HearingAid;
import com.example.hearoptima_d_03.entity.HraidImage;
import com.example.hearoptima_d_03.global.TConst;
import com.example.hearoptima_d_03.views.Common.MenuActivity;
import com.example.hearoptima_d_03.views.Common.MyPageActivity;
import com.example.hearoptima_d_03.views.HearingAidInfo.HearingAidInfo;
import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;

public class HearingAidFind extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    LinearLayout filter_btn,filter_layout;
    RangeSlider rangeSlider;
    TextView valueToText,valueFromText;
    ImageButton CrossBtn;
    ImageButton homeImageButton;
    ImageButton hearingAidInfoImageButton;
    SQLiteControl m_SqlCon;
    SQLiteHelper m_SqlHlp;
    private RecyclerView recyclerView;
    private HearingAidAdapter adapter;
    TextView AidsTotalnum;
    FilterDTO dto = new FilterDTO();
    AppCompatToggleButton[] shapeButtons = new AppCompatToggleButton[6];
    int[] shape_id = {R.id.shape1,R.id.shape2,R.id.shape3,R.id.shape4,R.id.shape5,R.id.shape6};
    AppCompatToggleButton[] brandButtons = new AppCompatToggleButton[10];
    ArrayList<HearingAid> aids = new ArrayList<>();
    AppCompatButton searchBtn,resetBtn;
    AppCompatToggleButton[] testButtons = new AppCompatToggleButton[3];
    int[] test_id = {R.id.numTb, R.id.priceTb, R.id.nameTb};
    int[] brand_id = {R.id.brand1,R.id.brand2,R.id.brand3,R.id.brand4,R.id.brand5,R.id.brand6,R.id.brand7,R.id.brand8,R.id.brand9,R.id.brand10};
    Spinner sortSpinner;
    ImageButton HearingAidNameSearch;
    ImageButton backBtn, myPageBtn;
    EditText HearingAidNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hearing_aid_list);

        homeImageButton = findViewById(R.id.HomeImage);
        homeImageButton.setOnClickListener(this);

        hearingAidInfoImageButton = findViewById(R.id.HearingAidInfoImage);
        hearingAidInfoImageButton.setOnClickListener(this);

        HearingAidNameSearch = findViewById(R.id.hearingaidnamesearch);
        HearingAidNameSearch.setOnClickListener(this);

        backBtn = findViewById(R.id.BackBtn);
        backBtn.setOnClickListener(this);

        myPageBtn = findViewById(R.id.MyPageImage);
        myPageBtn.setOnClickListener(this);

        HearingAidNameInput = findViewById(R.id.hearingaidnameinput);

        m_SqlHlp = new SQLiteHelper(HearingAidFind.this, TConst.DB_FILE, null, TConst.DB_VER);
        m_SqlCon = new SQLiteControl(m_SqlHlp);
        recyclerView = findViewById(R.id.my_recycler_view);

        AidsTotalnum = findViewById(R.id.AidsTotalnum);

        for (int i = 0; i < testButtons.length; i++) {
            testButtons[i] = findViewById(test_id[i]);
            testButtons[i].setOnCheckedChangeListener(this);
        }
        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(this);
        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(this);

        filter_btn = findViewById(R.id.filter_btn);
        filter_btn.setOnClickListener(this);
        filter_layout = findViewById(R.id.filter_layout);

        CrossBtn = findViewById(R.id.CrossBtn);
        CrossBtn.setOnClickListener(this);

        rangeSlider = findViewById(R.id.RangeSlider);
        rangeSlider.addOnSliderTouchListener(rangeSliderTouchListener);
        rangeSlider.addOnChangeListener(rangeSliderChangeListener);
        valueToText = findViewById(R.id.valueToText);
        valueFromText = findViewById(R.id.valueFromText);
        valueFromText.setText("5,000,000원");

        for (int i = 0; i < shapeButtons.length; i++) {
            shapeButtons[i] = findViewById(shape_id[i]);
            shapeButtons[i].setTextColor(getResources().getColorStateList(R.color.selector_text));
            shapeButtons[i].setOnCheckedChangeListener(this);
        }

        for (int i = 0; i < brandButtons.length; i++) {
            brandButtons[i] = findViewById(brand_id[i]);
            brandButtons[i].setTextColor(getResources().getColorStateList(R.color.selector_text));
            brandButtons[i].setOnCheckedChangeListener(this);

        }
        loadAllHearingAids();

        // shapeButtons 배열 초기화
        shapeButtons[0] = findViewById(R.id.shape1);
        shapeButtons[1] = findViewById(R.id.shape2);
        shapeButtons[2] = findViewById(R.id.shape3);
        shapeButtons[3] = findViewById(R.id.shape4);
        shapeButtons[4] = findViewById(R.id.shape5);
        shapeButtons[5] = findViewById(R.id.shape6);

        int dataValue = getIntent().getIntExtra("DAT_VALUE", -1);
        Log.d("HearingAidFind", "Received dataValue: " + dataValue);
        if (dataValue != -1) {
            applyInitialFilter(dataValue);
        }
    }
    private final RangeSlider.OnChangeListener rangeSliderChangeListener = new RangeSlider.OnChangeListener() {
        @SuppressLint("RestrictedApi")
        @Override
        public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");
            Log.d("DualThumbSeekbar ", "onValueChange minPrice : " + value);
            Log.d("DualThumbSeekbar ", "onValueChange maxPrice : " + value);
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");

            int miniNumber = Float.toString(slider.getValues().get(0)).indexOf(".");
            int maxNumber = Float.toString(slider.getValues().get(1)).indexOf(".");
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");
            Log.d("DualThumbSeekbar ", "onValueChange miniNumber : " + miniNumber);
            Log.d("DualThumbSeekbar ", "onValueChange maxNumber : " + maxNumber);
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");
            String minVal = Float.toString(slider.getValues().get(0)).substring(0, miniNumber);
            String maxVal = Float.toString(slider.getValues().get(1)).substring(0, maxNumber);
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");
            Log.d("DualThumbSeekbar ", "onValueChange minVal : " + minVal);
            Log.d("DualThumbSeekbar ", "onValueChange maxVal : " + maxVal);
            Log.d("DualThumbSeekbar ", "-----------------------------------------------------------------------------");
            String minV = String.format("%,d원", (Integer.parseInt(minVal))*50000);
            String maxV =String.format("%,d원", (Integer.parseInt(maxVal))*50000);
            valueToText.setText(minV);
            valueFromText.setText(maxV);
            dto.setMinPrice((Integer.parseInt(minVal))*50000);
            dto.setMaxPrice((Integer.parseInt(maxVal))*50000);
            Log.v("TEST LOG", "dto.setMin value : " + dto.getMinPrice());
            Log.v("TEST LOG", "dto.setMax value : " + dto.getMaxPrice());
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.hearingaidnamesearch){
            Log.v("HearingAidNameSearch", "찾았다"+v.getId());
            String strKeyWord = HearingAidNameInput.getText().toString().trim();
            Log.v("HearingAidNameSearch", "KeyWord = " + strKeyWord);
            aids = m_SqlCon.selectFromKeyWord(strKeyWord);

            if(null != aids){
                Log.v("HearingAidNameSearch", "search count = " + aids.size());
                setDataLists(aids);
            }
            return;

        } else if (v.getId() == R.id.BackBtn) {
//            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//            startActivity(intent);
            finish();
        }


        if (v.getId() == R.id.filter_btn) {
            filter_layout.setVisibility(View.VISIBLE);
            adapter.setItemClickable(false);
        }
        if (v.getId() == R.id.CrossBtn) {
            filter_layout.setVisibility(View.GONE);
            adapter.setItemClickable(true);
        }
        if (v.getId() == R.id.searchBtn) {
            filter_layout.setVisibility(View.INVISIBLE);
            ArrayList<Filter> shapes = new ArrayList<>();
            for (int i = 0; i < shapeButtons.length; i++) {
                if (shapeButtons[i].isChecked()) {
                    Filter filter = new Filter();
                    filter.setId(true);
                    filter.setItem("shape");
                    filter.setValue(shapeButtons[i].getText().toString());
                    shapes.add(filter);
                }
            }
            dto.setShapes(shapes);
            ArrayList<Filter> brands = new ArrayList<>();
            for (int i = 0; i < brandButtons.length; i++) {
                if (brandButtons[i].isChecked()) {
                    Filter filter = new Filter();
                    filter.setId(true);
                    filter.setItem("brand");
                    filter.setValue(brandButtons[i].getText().toString());
                    brands.add(filter);
                }
            }
            dto.setBrands(brands);
            Log.v("TEST LOG", "Filter getMaxPrice" + dto.getMaxPrice());
            Log.v("TEST LOG", "Filter getMinPrice" + dto.getMinPrice());
            for (int i = 0; i < dto.getBrands().size(); i++) {
                Log.v("TEST LOG", "Filter Log getBrands" + dto.getBrands().get(i).toString());
            }

            for (int i = 0; i < dto.getShapes().size(); i++) {
                Log.v("TEST LOG", "Filter Log getShapes" + dto.getShapes().get(i).toString());
            }

            aids = m_SqlCon.selectFilterHearingAid(dto);
            if (aids != null) {
                Log.v("TEST LOG", "aids size : " + aids.size());
                setDataLists(aids);
            }

        }

//        if (v.getId() == R.id.resetBtn) {
//            rangeSlider.setValues(0f, 100f);
//            for (int i = 0; i < shapeButtons.length; i++) {
//                if (shapeButtons[i].isChecked()) {
//                    shapeButtons[i].performClick();
//                }
//            }
//            for (int i = 0; i < brandButtons.length; i++) {
//                if (brandButtons[i].isChecked()) {
//                    brandButtons[i].performClick();
//                }
//            }
//        }

        if (v.getId() == R.id.resetBtn) {
            // 모든 브랜드 버튼 해제
            for (int brandButtonId : brand_id) {
                AppCompatToggleButton brandButton = findViewById(brandButtonId);
                if (brandButton != null) {
                    brandButton.setChecked(false);
                }
            }

            // 모든 형태 버튼 해제
            for (int shapeButtonId : shape_id) {
                AppCompatToggleButton shapeButton = findViewById(shapeButtonId);
                if (shapeButton != null) {
                    shapeButton.setChecked(false);
                }
            }

            // RangeSlider를 초기 범위로 설정
            rangeSlider.setValues(rangeSlider.getValueFrom(), rangeSlider.getValueTo());

            // 필터 숨기기 및 전체 보청기 목록 로드
            filter_layout.setVisibility(View.INVISIBLE);
            loadAllHearingAids();
        }

        if(v.getId() == R.id.HomeImage){
            Intent intent = new Intent(HearingAidFind.this, MenuActivity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.HearingAidInfoImage) {
            Intent intent = new Intent(HearingAidFind.this, HearingAidInfo.class);
            startActivity(intent);
        } else if (v.getId() == R.id.MyPageImage) {
            Intent intent = new Intent(HearingAidFind.this, MyPageActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            if(compoundButton.getText().toString().contains("이름")){
                Log.v("TEST LOG", "isChecked True");
                aids = m_SqlCon.selectOrderByAscPrice();
                setDataLists(aids);
            }
        } else {
            if(compoundButton.getText().toString().contains("이름")){
                Log.v("TEST LOG", "isChecked False");
                aids = m_SqlCon.selectOrderByDescPrice();
                setDataLists(aids);
            }
        }
    }

    public void setDataLists(ArrayList<HearingAid> data){
        if(data!=null){
            ArrayList<AidsView> dataLists = new ArrayList<>();
            AidsTotalnum.setText("총 " + data.size()+"개");
            for(int i=0; i<aids.size(); i++){
                AidsView aidsOne = new AidsView();
                aidsOne.setHa_id(data.get(i).getHa_id());
                aidsOne.setBrand(data.get(i).getHa_brand());
                aidsOne.setProduct(data.get(i).getHa_name());
                aidsOne.setMaxPrice(data.get(i).getHa_max_price());
                HraidImage hraidImage = m_SqlCon.selectImageFile(data.get(i).getHri_id());
                aidsOne.setFile_name(hraidImage.getHri_file_name());
                dataLists.add(aidsOne);
                Log.v("TEST LOG","datalist size : " + dataLists.size() );
            }
            if (recyclerView != null) {
                Log.v("TEST LOG","HistoryListAdapter if문 들어옴");
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                Log.v("TEST LOG","HistoryListAdapter if문 들어옴1");
                adapter = new HearingAidAdapter(dataLists,getResources(),getPackageName());
                Log.v("TEST LOG","HistoryListAdapter if문 들어옴2");
                recyclerView.setAdapter(adapter);
                Log.v("TEST LOG","HistoryListAdapter if문 들어옴3");
            }

        }
    }
    private final RangeSlider.OnSliderTouchListener rangeSliderTouchListener =
            new RangeSlider.OnSliderTouchListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public void onStartTrackingTouch(RangeSlider slider) {
                    int miniNumber = Float.toString(slider.getValues().get(0)).indexOf(".");
                    int maxNumber = Float.toString(slider.getValues().get(1)).indexOf(".");
                    String minVal = Float.toString(slider.getValues().get(0)).substring(0, miniNumber);
                    String maxVal = Float.toString(slider.getValues().get(1)).substring(0, maxNumber);
                }

                @SuppressLint("RestrictedApi")
                @Override
                public void onStopTrackingTouch(RangeSlider slider) {

                }
            };
    private void loadAllHearingAids() {
        aids = m_SqlCon.selectAllHearingAid(); // 데이터베이스에서 모든 보청기를 가져옵니다
        if (aids != null) {
            setDataLists(aids);
        }
    }

    private void applyInitialFilter(int dataValue) {
        Log.d("HearingAidFind dataValue", "Received dataValue: " + dataValue);

        // 모든 버튼을 초기 상태로 설정
        for(int i = 0; i < shapeButtons.length; i++) {
            if (shapeButtons[i] != null) {
                shapeButtons[i].setChecked(false);
            }
        }

        // dataValue에 따라 특정 형태의 버튼을 활성화
        if (dataValue <= 20) {
            // "정상"인 경우 특별한 필터 설정이 필요하지 않을 수 있음
        } else if (dataValue <= 40 || dataValue <= 55) {
            for(int i = 0; i <= 5; i++) {
                if (shapeButtons[i] != null) {
                    shapeButtons[i].setChecked(true);
                }
                if (shapeButtons[i] != null) {
                    boolean isChecked = shapeButtons[i].isChecked();
                    Log.d("HearingAidFind ShapeButton", "Button " + i + " isChecked: " + isChecked);
                }
            }
        } else if (dataValue <= 70 || dataValue <= 90) {
            // "외이도형", "귀걸이형" 활성화
            shapeButtons[1].setChecked(true); // 귀걸이형
            shapeButtons[3].setChecked(true); // 외이도형
            shapeButtons[5].setChecked(true); // 오픈형
            if (shapeButtons[1] != null) shapeButtons[1].setChecked(true); // 귀걸이형
            if (shapeButtons[3] != null) shapeButtons[3].setChecked(true); // 외이도형
            if (shapeButtons[5] != null) shapeButtons[5].setChecked(true); // 오픈형
        } else if (dataValue <= 200) {
            // "귀걸이형"만 활성화
            shapeButtons[1].setChecked(true); // 귀걸이형
            if (shapeButtons[1] != null) shapeButtons[1].setChecked(true); // 귀걸이형
        } else {
            // "데이터 잘못 입력" 처리
            Log.d("HearingAidFind", "잘못된 데이터 값: " + dataValue);
        }

        // 필터 적용된 데이터 불러오기
        filterAndLoadData();
    }

    private void filterAndLoadData() {
        // 선택된 필터에 따라 데이터를 불러오는 로직
        // 예: 선택된 버튼에 따라 dto 객체에 필터 값을 설정하고 데이터를 불러옵니다.
        ArrayList<Filter> shapes = new ArrayList<>();
        for (int i = 0; i < shapeButtons.length; i++) {
            if (shapeButtons[i].isChecked()) {
                Filter filter = new Filter();
                filter.setId(true);
                filter.setItem("shape");
                filter.setValue(shapeButtons[i].getText().toString());
                shapes.add(filter);
            }
        }
        dto.setShapes(shapes);
        aids = m_SqlCon.selectFilterHearingAid(dto);
        setDataLists(aids);
    }
    private void setButtonsEnabled(ViewGroup layout, boolean isEnabled) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                setButtonsEnabled((ViewGroup) child, isEnabled);
            } else if (child instanceof Button) {
                child.setEnabled(isEnabled);
            }
        }
    }

}