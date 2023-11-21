package com.example.hearoptima_d_01.views.HearingAidFind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearoptima_d_01.R;

import java.util.ArrayList;
import java.util.List;

public class HearingAidFind extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    HearingAidAdapter adapter;
    Spinner sortSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hearing_aid_list);

        // RecyclerView 설정
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HearingAidAdapter(getDummyData());
        recyclerView.setAdapter(adapter);

        // Spinner 설정
        sortSpinner = findViewById(R.id.sort_spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.sort_options, R.layout.spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(spinnerAdapter);

        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        // 최신순으로 정렬하는 코드
                        break;
                    case 1:
                        // 가격순으로 정렬하는 코드
                        break;
                    case 2:
                        // 이름순으로 정렬하는 코드
                        break;
                }
                adapter.notifyDataSetChanged(); // 정렬 후 어댑터에 데이터가 변경되었음을 알림
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않았을 때의 처리
            }
        });
    }

    private List<HearingAid> getDummyData() {
        List<HearingAid> hearingAids = new ArrayList<>();
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_1, "보청기1", "브랜드1", "1,000,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_2, "보청기2", "브랜드1", "1,200,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_3, "보청기3", "브랜드1", "1,500,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_4, "보청기4", "브랜드2","900,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_5, "보청기5", "브랜드2","700,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_6, "보청기6", "브랜드2","1,350,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_7, "보청기7", "브랜드3","1,420,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_8, "보청기8", "브랜드3","1,600,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_9, "보청기9", "브랜드3","1,430,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_10, "보청기10", "브랜드4","1,210,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_11, "보청기11", "브랜드4","1,542,000~"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_12, "보청기12", "브랜드4","4,000,000~"));
        return hearingAids;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.filter) {
            Intent intent = new Intent(getApplicationContext(), HearingAidFind.class);
            startActivity(intent);
        }
    }
}