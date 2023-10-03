package com.example.hearoptima_d_01.views.HearingAidFind;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearoptima_d_01.R;

import java.util.ArrayList;
import java.util.List;

public class HearingAidFind extends AppCompatActivity {

    RecyclerView recyclerView;
    HearingAidAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hearing_aid_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HearingAidAdapter(getDummyData());
        recyclerView.setAdapter(adapter);
    }

    private List<HearingAid> getDummyData() {
        List<HearingAid> hearingAids = new ArrayList<>();
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_1, "보청기1"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_2, "보청기2"));
        hearingAids.add(new HearingAid(R.drawable.hearing_aid_3, "보청기3"));
        return hearingAids;
    }
}
