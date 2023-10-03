package com.example.hearoptima_d_01.views.HearingAidFind;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hearoptima_d_01.R;

import java.util.List;

public class HearingAidAdapter extends RecyclerView.Adapter<HearingAidAdapter.ViewHolder> {

    private List<HearingAid> hearingAids;

    public HearingAidAdapter(List<HearingAid> hearingAids) {
        this.hearingAids = hearingAids;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_hearing_aid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HearingAid hearingAid = hearingAids.get(position);
        holder.imageView.setImageResource(hearingAid.getImageResourceId());
        holder.textView.setText(hearingAid.getName());
    }

    @Override
    public int getItemCount() {
        return hearingAids.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}